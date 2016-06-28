package com.pikia.wx.domain;

/**
 * 文本消息
 * 
 * @author bao
 * @date 2014-04-05
 */
public class TextMessage extends BaseMessage {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}