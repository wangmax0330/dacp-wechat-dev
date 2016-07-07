package com.showzhuang.controller.wechat;

import com.pikia.wx.domain.Button;
import com.pikia.wx.domain.Menu;
import com.pikia.wx.domain.ViewButton;

public class MenuHelp {
	public static Menu getMenu() {
		Menu menu = new Menu();
		Button[] btn = new Button[3]; // 主按钮

		// CommonButton cbtn32 = new CommonButton();
		// cbtn32.setName("首页");
		// cbtn32.setType("click");
		// cbtn32.setKey("jd_sao_zx_zx");
		// btn[0] = cbtn32;
		ViewButton cbtn32 = new ViewButton();
		cbtn32.setName("爆款预售");
		cbtn32.setType("view");
		cbtn32.setUrl("http://www.octlr.com/page/wechat.hot_product");
		btn[0] = cbtn32;   

		// CommonButton cbtn22 = new CommonButton();
		// cbtn22.setName("预约装修");
		// cbtn22.setType("pic_photo_or_album");
		// cbtn22.setKey("rselfmenu_1_1");

		ViewButton cbtn22 = new ViewButton();
		cbtn22.setName("工长加盟");
		cbtn22.setType("view");
		cbtn22.setUrl("http://www.octlr.com/page/wechat.chargehand_join");
		btn[1] = cbtn22;

		ViewButton cbtn11 = new ViewButton();
		cbtn11.setName("我要装修");
		cbtn11.setType("view");
		cbtn11.setUrl("http://www.octlr.com/wechat/index");
		btn[2] = cbtn11;

		menu.setButton(btn);
		return menu;
	}

}
