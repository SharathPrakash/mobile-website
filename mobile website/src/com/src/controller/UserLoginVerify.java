package com.src.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.UserLoginModel;

@WebServlet("/UserLoginVerify.do")
public class UserLoginVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
    private Map<String,String> errors=new HashMap<String,String>();

    public UserLoginVerify() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		email=request.getParameter("email");
		password=request.getParameter("password");
		if(email==null||email.length()==0){
			email="";
			errors.put("email","email cannot be left blank");
		}
		
		else if(password==null||password==""){
			password="";
			errors.put("password","password cannot be left blank");
		}
		
		else if(password.length()<3){
			password="";
			errors.put("password","password must be atleast 3 charecters");
		}
		else {
			errors.clear();
		}
		
		if(errors.isEmpty()){
			UserLoginModel data=new UserLoginModel();
			data.setEmail(request.getParameter("email"));
			data.setPassword(request.getParameter("password"));
		//	data.add(new UserLoginModel(request.getParameter(email),request.getParameter(password)));
			request.setAttribute("data", data);
			request.getRequestDispatcher("/UserConnection.do").forward(request,response);
		}
		
		else{
			request.setAttribute("email",email);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/UserLogin.view").forward(request, response);
		}
		
		}
	}


