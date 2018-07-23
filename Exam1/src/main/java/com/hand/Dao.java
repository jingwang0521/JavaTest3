package com.hand;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Dao {


	public  List<HashMap<String, Object>> queryCityByCountryId(Connection conn,int countryId)throws SQLException;

	public List<HashMap<String, Object>> queryFlimsByCustomer(Connection conn,int customerId)throws SQLException;


}
