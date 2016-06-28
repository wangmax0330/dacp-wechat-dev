package com.pikia.wx.domain;

/**
 * 音乐消息
 * 
 * @author bao
 * @date 2014-04-05
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}