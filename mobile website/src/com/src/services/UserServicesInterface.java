package com.src.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public interface UserServicesInterface {
	
	void setConnection(Connection con);
	ResultSet getData(String brand, String[] rearCamera, String[] frontCamera, String[] screenSize, String price) throws SQLException;
}
