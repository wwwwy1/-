package cn.Ideal.demo.schedule;

import cn.Ideal.demo.entity.*;
import cn.Ideal.demo.service.*;
import cn.Ideal.demo.util.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.solr.client.solrj.SolrServerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
@EnableScheduling
public class ScheduleTask {
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	@Autowired
	private IThumbUpService iThumbUpService;
	@Autowired
	private ITaskListService iTaskListService;
	@Autowired
	private IForumService iForumService;
	@Autowired
	private IReplyService iReplyService;
	@Autowired
	private IUserService iUserService;
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Scheduled(cron = "0 0 6 * * ?")  // 每天早上6点获取工作信息
	public void getJobsInfo() throws IOException, SolrServerException {
		redisTemplate.delete("jobs");
		List<Job> ret = JobUtil.getJobs();
		// 添加到缓存中
		redisTemplate.opsForValue().set("jobs", ret.toString());
		// 添加到solr中
		SolrUtil.deleteAll();
		SolrUtil.batchSaveOrUpdate(ret);
		logger.info("获取工作信息成功-定时任务");
	}
	@Transactional
	@Scheduled(cron = "0 0 0/1 * * ? ")
	public void redisDataToMySQL() {
		//插入用户已经点赞的文章
		Map<Object, Object> thumbUpForum = redisTemplate.opsForHash().entries(RedisKeyEnum.THUMB_UP_FORUM);//thumbUpReply
		for (Map.Entry<Object, Object> entry : thumbUpForum.entrySet()) {
			String userId = (String)entry.getKey();
			String forumIds = (String)entry.getValue();
			HashSet<Integer> integers = StringUtil.stringToSet(forumIds);
			// 待插入数据库
			for (Integer forumId : integers) {
				QueryWrapper<ThumbUp> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("user_id",userId).eq("forum_id",forumId);
				iThumbUpService.remove(queryWrapper);
				iThumbUpService.save(new ThumbUp(userId,forumId,1));
				// 给用户增加赞（声望）
				Forum byId = iForumService.getById(forumId);
				iUserService.addUserPoint(byId.getUserId());
			}
		}
		//插入用户已经踩的文章
		Map<Object, Object> thumbDownForum = redisTemplate.opsForHash().entries(RedisKeyEnum.THUMB_DOWN_FORUM);
		for (Map.Entry<Object, Object> entry : thumbDownForum.entrySet()) {
			String userId = (String)entry.getKey();
			String forumIds = (String)entry.getValue();
			HashSet<Integer> integers = StringUtil.stringToSet(forumIds);
			// 待插入数据库
			for (Integer forumId : integers) {
				QueryWrapper<ThumbUp> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("user_id",userId).eq("forum_id",forumId);
				iThumbUpService.remove(queryWrapper);
				iThumbUpService.save(new ThumbUp(userId,forumId,2));
				// 给用户增加赞（声望）
				Forum byId = iForumService.getById(forumId);
				iUserService.removeUserPoint(byId.getUserId());
			}
		}
		//插入用户已经点赞的评论
		Map<Object, Object> thumbUpReply = redisTemplate.opsForHash().entries(RedisKeyEnum.THUMB_UP_REPLY);//thumbUpReply
		for (Map.Entry<Object, Object> entry : thumbUpReply.entrySet()) {
			String userId = (String)entry.getKey();
			String forumIds = (String)entry.getValue();
			HashSet<Integer> integers = StringUtil.stringToSet(forumIds);
			// 待插入数据库
			for (Integer id : integers) {
				QueryWrapper<ThumbUp> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("user_id",userId).eq("reply_id",id);
				iThumbUpService.remove(queryWrapper);
				iThumbUpService.save(new ThumbUp(userId,0,id,1));
				// 给用户增加赞（声望）
				Reply byId = iReplyService.getById(id);
				iUserService.addUserPoint(byId.getReplyUserId());
			}
		}
		//插入用户已经踩的评论
		Map<Object, Object> thumbDownReply = redisTemplate.opsForHash().entries(RedisKeyEnum.THUMB_DOWN_REPLY);//thumbUpReply
		for (Map.Entry<Object, Object> entry : thumbDownReply.entrySet()) {
			String userId = (String)entry.getKey();
			String ids = (String)entry.getValue();
			HashSet<Integer> integers = StringUtil.stringToSet(ids);
			// 待插入数据库
			for (Integer id : integers) {
				QueryWrapper<ThumbUp> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("user_id",userId).eq("reply_id",id);
				iThumbUpService.remove(queryWrapper);
				iThumbUpService.save(new ThumbUp(userId,0,id,2));
				// 给用户增加赞（声望）
				Reply byId = iReplyService.getById(id);
				iUserService.removeUserPoint(byId.getReplyUserId());
			}
		}
		//更新文章数据库中的赞，点击量，回复数
		Map<Object, Object> entries = redisTemplate.opsForHash().entries(RedisKeyEnum.FORUM_KEY);
		for (Map.Entry<Object, Object> entry : entries.entrySet()) {
			String forumId = (String)entry.getKey();
			String clicks = (String)entry.getValue();
			String[] split = clicks.split(",");
			iForumService.updateById(new Forum(Integer.valueOf(forumId),Integer.valueOf(split[2]),Integer.valueOf(split[1]),Integer.valueOf(split[0])));
		}
		//更新回复数据库中的赞
		Map<Object, Object> replyEntries = redisTemplate.opsForHash().entries(RedisKeyEnum.REPLY_KEY);
		for (Map.Entry<Object, Object> entry : replyEntries.entrySet()) {
			String id = (String)entry.getKey();
			String value = (String)entry.getValue();
			iReplyService.updateById(new Reply(Integer.valueOf(id),Integer.valueOf(value)));
		}

	}
	// 任务清单定时插入数据库
	@Transactional
	@Scheduled(cron = "0 0 0/1 * * ? ")
	public void taskListRedisToMySQL(){
		Map<Object, Object> taskLists = redisTemplate.opsForHash().entries(RedisKeyEnum.TASK_LIST_KEY);
		for (Map.Entry<Object, Object> task : taskLists.entrySet()) {
			String userId = (String)task.getKey();
			String ret = (String)task.getValue();
			Map<String,String> map = StringUtil.stringToObj(ret, Map.class);
			List<TaskList> dont = StringUtil.jsonToTaskList(map.get("dont"), userId);
			List<TaskList> doing = StringUtil.jsonToTaskList(map.get("doing"), userId);
			List<TaskList> did = StringUtil.jsonToTaskList(map.get("did"), userId);
			iTaskListService.deleteByUserId(userId);
			iTaskListService.saveBatch(doing);
			iTaskListService.saveBatch(dont);
			iTaskListService.saveBatch(did);
		}

	}
}
