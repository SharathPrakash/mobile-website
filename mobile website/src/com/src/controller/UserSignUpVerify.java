package com.src.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.src.model.UserLoginModel;
/**
 * Servlet implementation class UserSignUpVerify
 */
@WebServlet("/UserSignUpVerify.do")
public class UserSignUpVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String first_name,last_name,email_ID,password,repassword,address,city,state,pincode,mobnum;
	String efirst_name,elast_name;
    private Map<String,String> SignUperrors=new HashMap<String,String>();

    public UserSignUpVerify() {
        super();
    }

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PrintWriter out=response.getWriter();
		//taking input parameters
		first_name=request.getParameter("first_name").trim();
		last_name=request.getParameter("last_name").trim();
		email_ID=request.getParameter("email_ID").trim();
		password=request.getParameter("password").trim();
		repassword=request.getParameter("repassword").trim();
		address=request.getParameter("address").trim();
		city=request.getParameter("city").trim();
		state=request.getParameter("state").trim();
		pincode=request.getParameter("pincode").trim();
		mobnum=request.getParameter("mobnum").trim();
		//first name 
		if(first_name==null||first_name.length()==0)
		{
			first_name="";
			SignUperrors.put(efirst_name, "first name can't be left blank");
			
		}
		else
		{request.setAttribute("first_name",first_name);
		request.setAttribute("SignUperrors", SignUperrors);
		request.getRequestDispatcher("/UserSignup.view").forward(request, response);
	
			
		}
		
		//last name
		if(last_name==null||last_name.length()==0)
		{
			last_name="";
			SignUperrors.put(elast_name, "last name can't be left blank");
			
		}
		
		
		else
		{	request.setAttribute("last_name",last_name);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
		//email id
		if(email_ID==null||email_ID.length()==0)
		{
			email_ID="";
			SignUperrors.put(email_ID, "last name can't be left blank");
			
		}
		
		
		else
		{	request.setAttribute("email_ID",first_name);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
		//password
		
		if(password==null||password.length()==0)
		{
			password="";
			SignUperrors.put(password, "password must be alteast ");
			
		}
		else
		{	request.setAttribute("password",password);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
		//repassword
		if(repassword==null||repassword.length()==0 && repassword!=password)
		{
			repassword="";
			SignUperrors.put(repassword, "first name can't be left blank");
			
		}
		else
		{	request.setAttribute("repassword",repassword);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
		//address
		if(address==null||address.length()==0)
		{
			address="";
			SignUperrors.put(address, "first name can't be left blank");
			
		}
		else
		{	request.setAttribute("address",address);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
		
		//city
		if(city==null||city.length()==0)
		{
			city="";
			SignUperrors.put(city, "first name can't be left blank");
			
		}
		else
		{	request.setAttribute("city",city);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
		//state
		if(state==null||state.length()==0)
		{
			state="";
			SignUperrors.put(state, "first name can't be left blank");
			
		}
		else
		{	request.setAttribute("state",state);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
				
		}
				
		//pincode
		if(pincode==null||pincode.length()==0)
		{
			pincode="";
			SignUperrors.put(pincode, "first name can't be left blank");
			
		}
		else
		{	request.setAttribute("pincode",pincode);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		
		}
		
		//mobnum
		if(mobnum==null||mobnum.length()==0)
		{
			mobnum="";
			SignUperrors.put(mobnum, "first name can't be left blank");
			
		}
		else
		{	request.setAttribute("mobnum",mobnum);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignup.view").forward(request, response);
		}
		
		
		
		
		
	}

}
