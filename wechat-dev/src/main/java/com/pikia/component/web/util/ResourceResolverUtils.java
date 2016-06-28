package com.pikia.component.web.util;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Methew 
 * 统一一管理获取eclipse工程/文件目录的方法
 */
public class ResourceResolverUtils {
	String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(new File("com/log4j.properties").getAbsolutePath());
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
//		System.out.println(context.);
	}
	// 雨伞 1. 获取系统根目录
	// System.getProperty("user.home");
	// 例如输出，C:\Users\hutu
	// 雨伞 2. 获取工程目录
	// System.getProperty("user.dir");
	// 例如输出，D:\workspaces\workspace1\myProject
	// 雨伞 3. 新建文件，默认位于工程目录
	// new File("xxx.txt").getAbsolutePath();
	// 例如输出，D:\workspaces\workspace1\myProject
	// 雨伞 4. 配置文件路径
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("Config.xml");
	// .xml, .properties等，默认还是从“工程目录”去找的
	// 1). 倒是也可以用绝对路径，真心不推荐啊，太不优雅了；
	// 2). 或者，将log4j文件置于bin/目录下：
	// a). 代码中，PropertyConfigurator.configure("bin/log4j.properties");
	// b).
	// 代码中，PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
	// c). 注意，必须位于bin直接目录下，不可位于bin更深层的目录当中。可是这究竟是为神马捏？

	// 雨伞 5. 查询某类的.class文件所在目录
	// 例如输出，D:\workspaces\workspace1\myProject\bin\com\hutu\log4j\
	// Main.class.getResource(“”);
	//
	// 注意，查询包上级路径，只需将参数改作“/”
	// 雨伞 6. 查询thread上下文所在目录
	// Thread.currentThread().getContextClassLoader().getResource("");
	// 例如输出，D:\workspaces\workspace1\myProject\bin\
	// 雨伞 7. 查询某类的classloader所在目录
	// Main.class.getClassLoader().getResource("");
	// 例如输出，D:\workspaces\workspace1\myProject\bin\
	// 查询classloader所在目录
	// 例如输出，D:\workspaces\workspace1\myProject\bin\
	// ClassLoader.getSystemResource("");

}
