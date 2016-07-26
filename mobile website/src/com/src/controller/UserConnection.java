package com.src.controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//import com.mysql.jdbc.Connection;
import com.src.model.UserLoginModel;

@WebServlet("/UserConnection.do")
public class UserConnection extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	public UserConnection() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLoginModel data=(UserLoginModel)request.getAttribute("data");
		PrintWriter out=response.getWriter();
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mobile_store");
			Connection con =(Connection) ds.getConnection();
			CallableStatement cs=con.prepareCall("call passwordchecker(?,?,?)");
			cs.setString(1,data.getEmail());
			cs.setString(2,data.getPassword());
			cs.setInt(3,Types.FLOAT);
			ResultSet rs=cs.executeQuery();
			while(rs.next()){
			if(Integer.parseInt(rs.getString(1))==0){
				out.println("wrong password");
				
			}
			else{
				out.println("success");
			}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
