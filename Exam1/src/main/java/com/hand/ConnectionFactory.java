package com.hand;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {

	public static String driver;
	public static String url;
	public static String user;
	public static String password;
	public  static int countryId;

	private Connection conn;


	//单例模式
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();

	private ConnectionFactory() {


	}

	public static ConnectionFactory getInstance() {
		return connectionFactory;
	}



	static {
		Properties properties = new Properties();
		try {

			//InputStream in =new FileInputStream("../JavaTest3/dbconfig.properties");
			InputStream in =new FileInputStream("Exam1/docker-compose.yml");
			properties.load(in);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("=====读取配置文件错误=====");
		}

		driver = properties.getProperty("driver");
		url = properties.getProperty("url");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
	}

	//获取数据库连接
	public Connection makeConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
