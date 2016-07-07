package com.showzhuang.controller.wechat;

import com.pikia.wx.util.WeixinUtil;

public class ReChangeWechatMenu {

	public static void main(String[] args) {
		String token = WeixinUtil.getAccessToken().getToken();
		System.out.println(WeixinUtil.appid);
		System.out.println(token);
		WeixinUtil.deleteMenu(token);
		WeixinUtil.createMenu(token, MenuHelp.getMenu());
	}
}
