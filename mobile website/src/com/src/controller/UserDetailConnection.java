package com.src.controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.src.model.UserSingUpModel;



/**
 * Servlet implementation class UserDetailConnection
 */
@WebServlet("/UserDetailConnection.do")
public class UserDetailConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List <UserSingUpModel>details=(LinkedList<UserSingUpModel>)request.getAttribute("userDetails");
		Iterator<UserSingUpModel> itr=details.iterator();
	
		
		try
		{
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mobile_store");
			Connection cn=(Connection) ds.getConnection();
			while(itr.hasNext()){
				UserSingUpModel detail=(UserSingUpModel)itr.next();
					CallableStatement cs=cn.prepareCall("call insertuserdetail(?,?,?,?,?,?,?,?,?);");
					cs.setString(1, detail.getEmailId());
					cs.setString(2, detail.getFirstName());
					cs.setString(3, detail.getLastName());
					cs.setString(4, detail.getPassword());
					cs.setString(5, detail.getAddress());
					cs.setString(7, detail.getCity());
					cs.setString(6, detail.getState());
					cs.setInt(8, detail.getPincode());
					cs.setString(9, detail.getMobnum());
					cs.executeQuery();
					
					request.getRequestDispatcher("/Sucess.view").forward(request,response);
					System.out.println("sucess");
			}
		}
		catch(MySQLIntegrityConstraintViolationException exe)
		{
			Map<String,String> unerror=new HashMap<String,String>();
		   unerror.put("emailId", "email/phone is already registered");
		   unerror.put("mobnum", "email/phone is already registered");
		   request.setAttribute("unerror",unerror);
		   request.getRequestDispatcher("/UserSignUpVerify.do").forward(request, response);
		}
		catch(SQLException ex)
		{
			
			ex.printStackTrace();
			
		}
		catch (NamingException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
	}

}
