package com.src.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceClass implements UserServicesInterface {
Connection con=null;
	@Override
	public void setConnection(Connection con) {
		this.con=con;
	}

	@Override
	public ResultSet getData(String brand, int rearCamera, int frontCamera, int screenSize,
			int price) throws SQLException{
		/*System.out.println("Values inside user service class");
		System.out.println(brand);
		System.out.println(rearCamera);
		System.out.println(frontCamera);
		System.out.println(screenSize);
		System.out.println(price);*/
		PreparedStatement cstmt= con.prepareStatement("select * from mobile_specs where company_name like ? and camera_front>? and camera_rear>? and screen_size>? and price>?");
		cstmt.setString(1, brand);
		cstmt.setInt(2, frontCamera);
		cstmt.setInt(3, rearCamera);
		cstmt.setInt(4, screenSize);
		
		cstmt.setInt(5, price);
		
		ResultSet rs=cstmt.executeQuery();
		return rs;
	}

	


}
