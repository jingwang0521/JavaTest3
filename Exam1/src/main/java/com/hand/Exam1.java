package com.hand;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Exam1 {

	public  static int countryId;
	public  static int customerId;
	public static  void main(String[] args) throws  Exception{
		Connection conn=null;

		try {

			ConnectionFactory factory=ConnectionFactory.getInstance();
			conn=factory.makeConnection();

			conn.setAutoCommit(false);
			System.out.println("=========1================");
			Dao dao=new DaoImpl();
			dao.queryCityByCountryId(conn,countryId);
			System.out.println("===========2==============");
			dao.queryFlimsByCustomer(conn,customerId);

			conn.commit();

		}catch (Exception e){
			e.printStackTrace();
		}


	}


	static {

		try{
			Properties properties = new Properties();

			//InputStream in =new FileInputStream("../JavaTest3/dbconfig.properties");
			InputStream in =new FileInputStream("Exam1/docker-compose.yml");
			properties.load(in);

			countryId = Integer.parseInt(properties.getProperty("countryId"));
			customerId = Integer.parseInt(properties.getProperty("customerId"));
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
