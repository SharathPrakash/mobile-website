package com.src.controller;

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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.src.model.ManagerModel;


@WebServlet("/ManagerConnection.do")
public class ManagerConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ManagerConnection() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerModel data=(ManagerModel)request.getAttribute("data");
		PrintWriter out=response.getWriter();
		try {
			//connecting to database jndl
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/mobile_store");
			Connection con =(Connection) ds.getConnection();
			//calling procedure written in mysql mobile_store
			CallableStatement cs=con.prepareCall("call Managerpasswordchecker(?,?,?)");
			cs.setString(1,data.getManagerId());
			cs.setString(2,data.getPassword());
			cs.setInt(3,Types.FLOAT);
			ResultSet rs=cs.executeQuery();
			while(rs.next()){
			if(Integer.parseInt(rs.getString(1))==0){
				request.setAttribute("invalidManager","Email or password is wrong please try again");//msg to be printed if login is unsuccessful
				request.getRequestDispatcher("/ManagerLogin.view").forward(request, response);
			}
			else{
				HttpSession session=request.getSession();
				session.setAttribute("connection", con);
				request.getRequestDispatcher("/ManagerPage.view").forward(request,response);
				
			}
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	}


