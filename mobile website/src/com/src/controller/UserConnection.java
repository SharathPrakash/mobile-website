package com.src.controller;

import java.util.List;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.src.model.UserLoginModel;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

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
		
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/lookup/mobile_store");
			Connection con =(Connection) ds.getConnection();
			CallableStatement cs=con.prepareCall("call passwordchecker(?,?)");
			cs.setString(1,data.getEmail());
			cs.setString(2,data.getPassword());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
