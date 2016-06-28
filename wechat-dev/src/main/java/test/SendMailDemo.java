//package test;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeUtility;
// 
//public class SendMailDemo {
// 
//    static int port = 25;
// 
//    static String server = "smtp.qq.com";//邮件服务器mail.cpip.net.cn
// 
//    static String from = "邮件发送者";//发送者,显示的发件人名字
// 
//    static String user = "1972571217@qq.com";//发送者邮箱地址
// 
//    static String password = "13183199257";//密码
// 
//    
//    public static void sendEmail(String email, String subject, String body) throws UnsupportedEncodingException {
//        try {
//        	subject = new String(subject.getBytes("ISO-8859-1"),"UTF-8");
//            Properties props = new Properties();
//            props.put("mail.smtp.host", server);
//            props.put("mail.smtp.port", String.valueOf(port));
//            props.put("mail.smtp.auth", "true");
//            Transport transport = null;
//            Session session = Session.getDefaultInstance(props, null);
//            transport = session.getTransport("smtp");
//            transport.connect(server, user, password);
//            MimeMessage msg = new MimeMessage(session);
//            msg.setSentDate(new Date());
//            InternetAddress fromAddress = new InternetAddress(user,from,"UTF-8");
//            msg.setFrom(fromAddress);
//            InternetAddress[] toAddress = new InternetAddress[1];
//            toAddress[0] = new InternetAddress(email);
//            msg.setRecipients(Message.RecipientType.TO, toAddress);
//            MimeUtility.encodeText(subject,"big5","B");
//            //msg.setSubject(subject, "UTF-8");  
//            msg.setText(body.toString(), "UTF-8");
//            msg.saveChanges();
//            transport.sendMessage(msg, msg.getAllRecipients());
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String args[]) throws UnsupportedEncodingException
//    {
// 
//        sendEmail("970898664@qq.com","邮件测试","hello");//收件人
//        System.out.println("ok");
//    }
//}