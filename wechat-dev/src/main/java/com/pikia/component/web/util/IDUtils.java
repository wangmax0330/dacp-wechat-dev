package com.pikia.component.web.util;

import java.util.Random;
import java.util.UUID;

/**
 * 各种id生成策略
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * <p>Company: www.shj.com</p> 
 * @author	杨青见
 * @date	2015年7月22日下午2:32:10
 * @version 1.0
 */
public class IDUtils {
	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
//		long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * ID主键生成策略
	 */
	public static long genPrimaryId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
//		long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足两位前面补0
		String str = millis + String.format("%03d", end3);
		long id = new Long(str);
		return id;
	}
	/**
	 * 得到UUID
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public static void main(String[] args) {
		 /*
		 	String source = "111111";
		    String salt = "uiwueylm";
		    int hashIterations = 1;
		    Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		    String password_md5 = md5Hash.toString();
		    
		    System.out.println(password_md5);
		    SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
		    System.out.println(simpleHash.toString());
		   */
	}
	/*public static void main(String[] args) {
		System.out.println(getUUID()); ;
	}*/
}
