//package test;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//
//import com.pikia.aps.domain.ApsUserDomain;
//
//public class JDBCTemplateTest {
//	private static ApplicationContext context = new ClassPathXmlApplicationContext("config/serverContext-*.xml");
//	protected JdbcTemplate jdbcTemplate;
//
//	public void insert() {
//		final ApsUserDomain userDomain = new ApsUserDomain();
//		userDomain.setUserName("Methew");
//		userDomain.setMobile("13108355337");
//		userDomain.setCreateTime(new Date());
//		jdbcTemplate.update("insert into APS_USER(USER_NAME,MOBILE,CREATE_TIME) values(?,?,?)",
//				new PreparedStatementSetter() {
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//						ps.setString(1, userDomain.getUserName());
//						ps.setString(2, userDomain.getMobile());
//						// ps.setDate(3, new
//						// java.sql.Date(userDomain.getCreateDate().getTime()));
//						ps.setTimestamp(3, new java.sql.Timestamp(userDomain.getCreateTime().getTime()));
//
//					}
//				});
//	}
//
//	public Long save(ApsUserDomain userDomain) {
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		final ApsUserDomain user = userDomain;
//		int te = jdbcTemplate.update(new PreparedStatementCreator() {
//			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//				String sql = "insert into APS_USER(USER_NAME,MOBILE,CREATE_TIME,WECHAT_ACCOUNT) values(?,?,?,?)";
//				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, user.getUserName());
//				ps.setString(2, user.getMobile());
//				ps.setTimestamp(3, new java.sql.Timestamp(user.getCreateTime().getTime()));
//				ps.setString(4, user.getWechatAccount());
//				return ps;
//			}
//		}, keyHolder);
//		System.out.println(te);
//		Long generatedId = keyHolder.getKey().longValue();
//		return generatedId;
//	}
//
//	public Long update(ApsUserDomain userDomain) {
//		final ApsUserDomain user = userDomain;
//		int te = jdbcTemplate.update(new PreparedStatementCreator() {
//			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//				String sql = "update  APS_USER set USER_NAME=?,MOBILE=?,WECHAT_ACCOUNT=? where ID =?";
//				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//				ps.setString(1, user.getUserName());
//				ps.setString(2, user.getMobile());
//				ps.setString(3, user.getWechatAccount());
//				ps.setLong(4, user.getId());
//				return ps;
//			}
//		});
//		return userDomain.getId();
//	}
//
//	public static void main(String[] args) {
//		try {
//			JDBCTemplateTest template = new JDBCTemplateTest();
//			template.jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
//			final ApsUserDomain userDomain = new ApsUserDomain();
//			userDomain.setUserName("Methew");
//			userDomain.setMobile("13108355337");
//			userDomain.setCreateTime(new Date());
//			userDomain.setId(1l);
//			// template.insert();
//			// Long id = template.save(userDomain);
//			// System.out.println(id);
//			template.update(userDomain);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
