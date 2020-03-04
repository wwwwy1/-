package cn.Ideal.demo.entity;

import lombok.Data;

@Data
public class ChatMessage {
	private MessageType type; // 消息类型
	private String content;  // 消息内容
	private String sender;   // 发送者

	public enum MessageType{
		CHAT, // 消息
		JOIN, // 加入
		LEAVE // 离开
	}
}
