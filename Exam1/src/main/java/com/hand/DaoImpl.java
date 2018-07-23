package com.hand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class DaoImpl implements Dao {

	@Override
	public  List<HashMap<String, Object>> queryCityByCountryId(Connection conn,int countryId) throws SQLException {
		PreparedStatement ps=conn.
				prepareCall("select  city_id,city from city where country_id=?");

		ps.setInt(1,countryId);

		ResultSet rs=ps.executeQuery();

		while (rs.next()){
			int city_id=rs.getInt(1);
			String city=rs.getString(2) ;

			System.out.println("id\t"+city_id+"|\t"+city);
		}
		return null;
	}


	@Override
	public List<HashMap<String, Object>> queryFlimsByCustomer(Connection conn,int customerId) throws SQLException {

		PreparedStatement ps=conn.
				prepareCall("   select rental.rental_date,inventory.film_id,film.title from rental,inventory,film\n" +
						"\t\twhere rental.inventory_id=inventory.inventory_id\n" +
						"\t\tand inventory.film_id=film.film_id\n" +
						"\t\tand rental.customer_id=?\n" +
						"\t\torder by rental_date desc");

		ps.setInt(1,customerId);

		ResultSet rs=ps.executeQuery();

		while (rs.next()){
			String rental_date=rs.getString(1) ;
			int Film_id=rs.getInt(2);
			String title=rs.getString(3) ;

			System.out.println("\t"+Film_id+"\t|\t"+title+"\t|\t"+rental_date+"\t");
		}
		return null;
	}}
