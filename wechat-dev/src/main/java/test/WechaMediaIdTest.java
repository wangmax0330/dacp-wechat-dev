package test;

import java.io.IOException;

import com.pikia.wx.util.WeixinUtil;

import net.sf.json.JSONObject;

public class WechaMediaIdTest {
	public static void main(String[] args) {
		try {
			String accessToken = WeixinUtil2.getAccessToken(WeixinUtil.appid, WeixinUtil.appsecret).getToken();
			JSONObject json = WeixinUtil2.uploadMediaToWX("/home/methew/aaa.png", "image", accessToken);
			System.out.println(json.toString());
			String mediaId = json.getString("media_id");
			System.out.println("mediaId: " + mediaId);
			System.out.println("accessToken: " + accessToken);

			System.out
					.println("分割线*******************************************************************************************");
			/**
			 * 下载多媒体文件
			 */
			WeixinUtil2.downloadMediaFromWx(accessToken, mediaId, "/home/methew");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
