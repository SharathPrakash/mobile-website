package com.src.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		//PrintWriter out=response.getWriter();
		//taking input parameters
		email=request.getParameter("email").trim();
		password=request.getParameter("password").trim();
		//checking for errors in email
		Pattern mail=Pattern.compile("@.*.com");
		Matcher validemail=mail.matcher(email);
		
		if(email==null||email.length()==0){
			email="";
			errors.put("email","email cannot be left blank");
			//checking for errors in password when there is error in email
			if(password==null||password==""){
				password="";
				errors.put("password","password cannot be left blank");
			}
			
			else if(password.length()<3){
				password="";
				errors.put("password","password must be atleast 3 charecters");
			}
		
		}
		//email errors
		
		else if(!validemail.find()){
			email="";
			errors.put("email","not a valid email");
			//checking for errors in password when there is error in email
			if(password==null||password==""){
				password="";
				errors.put("password","password cannot be left blank");
			}
			
			else if(password.length()<3){
				password="";
				errors.put("password","password must be atleast 3 charecters");
			}
		}
		//checking for error in password when no error in email
		else if(password==null||password==""){
			password="";
			errors.put("email","");
			errors.put("password","password cannot be left blank");
		}
		
		else if(password.length()<3){
			password="";
			errors.put("email","");
			errors.put("password","password must be atleast 3 charecters");
		}
		//clearing error if stored from previous request
		else {
			errors.clear();
		}
		
		if(errors.isEmpty()){
			//checking email and password  in database
			UserLoginModel data=new UserLoginModel();
			data.setEmail(request.getParameter("email"));
			data.setPassword(request.getParameter("password"));
			request.setAttribute("data", data);
			request.getRequestDispatcher("/UserConnection.do").forward(request,response);
		}
		
		else{
			//sending errors to the front page
			request.setAttribute("email",email);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/UserLogin.view").forward(request, response);
		}
		
		}
	}