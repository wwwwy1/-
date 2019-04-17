package cn.Ideal.demo.entity;

import java.util.Date;

public class Reply {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.Rid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    private Integer rid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.Cid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    private Integer cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.Ridrp
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    private String ridrp;
    private User ruser;

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", cid=" + cid +
                ", ridrp='" + ridrp + '\'' +
                ", ruser=" + ruser +
                ", user=" + user +
                ", rn=" + rn +
                ", ruid=" + ruid +
                ", uid=" + uid +
                ", dtime=" + dtime +
                ", father=" + father +
                '}';
    }

    public User getRuser() {
        return ruser;
    }

    public void setRuser(User ruser) {
        this.ruser = ruser;
    }

    private User user;
    private Integer rn;

    private Integer ruid;

    public Integer getRuid() {
        return ruid;
    }

    public void setRuid(Integer ruid) {
        this.ruid = ruid;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.uid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.dtime
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    private Date dtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reply.father
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    private Integer father;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.Rid
     *
     * @return the value of reply.Rid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.Rid
     *
     * @param rid the value for reply.Rid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.Cid
     *
     * @return the value of reply.Cid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.Cid
     *
     * @param cid the value for reply.Cid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.Ridrp
     *
     * @return the value of reply.Ridrp
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public String getRidrp() {
        return ridrp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.Ridrp
     *
     * @param ridrp the value for reply.Ridrp
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public void setRidrp(String ridrp) {
        this.ridrp = ridrp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.uid
     *
     * @return the value of reply.uid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.uid
     *
     * @param uid the value for reply.uid
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.dtime
     *
     * @return the value of reply.dtime
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public Date getDtime() {
        return dtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.dtime
     *
     * @param dtime the value for reply.dtime
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reply.father
     *
     * @return the value of reply.father
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public Integer getFather() {
        return father;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reply.father
     *
     * @param father the value for reply.father
     *
     * @mbggenerated Sat Apr 13 12:40:47 GMT+08:00 2019
     */
    public void setFather(Integer father) {
        this.father = father;
    }
}