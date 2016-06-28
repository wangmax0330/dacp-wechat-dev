import com.pikia.wx.util.WeixinUtil;

public class TestWx {

	public static void main(String[] args) {
		String token = WeixinUtil.getAccessToken().getToken();
		System.out.println(token);
		WeixinUtil.deleteMenu(token);
		WeixinUtil.createMenu(token, MenuHelpBackUp.getMenu());

	}

}
