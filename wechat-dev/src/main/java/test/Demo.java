//package test;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import com.pikia.wx.domain.Article;
//import com.pikia.wx.domain.MessageUtil;
//import com.pikia.wx.domain.NewsMessage;
//import com.pikia.wx.repository.WeixinRepository;
//
//@Component
//public class Demo {
//
//	private static ApplicationContext context = new ClassPathXmlApplicationContext(
//			"config/serverContext-*.xml");
//
//	public static void main(String[] args) {
//
//		final WeixinRepository weixinRepository = (WeixinRepository) context
//				.getBean("weixinRepository");
//		NewsMessage news = new NewsMessage();
//		List<Article> articles = new ArrayList<Article>();
//		Article article = new Article();
//		SimpleDateFormat dateFormat = new SimpleDateFormat(
//				"yyyy-MM-dd HH:mm:ss");
//		String endDate = dateFormat.format(new Date());
//		List<Long> couponList = weixinRepository.getHotCouponToWeChat(endDate,
//				3);
//		for (Long domain : couponList) {
//			article.setPicUrl("domain" + domain);
//			article.setTitle("sdsd");
//			article.setDescription("sdf  ");
//			article.setUrl("http://admin-test.p1pai.com/web/weixin/detail/");
//			articles.add(article);
//		}
//		news.setArticleCount(3);
//		news.setArticles(articles);
//		System.out.println(MessageUtil.newsMessageToXml(news));
//	}
//
//}
