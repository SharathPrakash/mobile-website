package com.src.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserServiceClass implements UserServicesInterface {
Connection con=null;
	@Override
	public void setConnection(Connection con) {
		this.con=con;
	}

	@Override
	public ResultSet getData(String brand, String[] rearCamera, String[] frontCamera, String[] screenSize,
			String price) throws SQLException{
		Statement cstmt= con.createStatement();
		ResultSet rs=cstmt.executeQuery("select * from mobile_specs");
		return rs;
	}


}
