package com.src.services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public interface UserServicesInterface {
	
	void setConnection(Connection con);
	ResultSet getData(String brand, int rearCamera, int frontCamera, int screenSize, int price)
			throws SQLException;
}
