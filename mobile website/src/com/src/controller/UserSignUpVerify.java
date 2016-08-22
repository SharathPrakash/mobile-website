package com.src.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.UserSingUpModel;

//import com.src.model.UserLoginModel;
/**
 * Servlet implementation class UserSignUpVerify
 */
@WebServlet("/UserSignUpVerify.do")
public class UserSignUpVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String firstName,lastName,emailId,password,repassword,address,city,state,pincode,mobnum;
	
    Map<String,String> SignUperrors=new HashMap<String,String>();
    

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
		SignUperrors.clear();
		firstName=request.getParameter("firstName").trim();
		lastName=request.getParameter("lastName").trim();
		emailId=request.getParameter("emailId").trim();
		password=request.getParameter("password").trim();
		repassword=request.getParameter("repassword").trim();
		address=request.getParameter("address").trim();
		city=request.getParameter("city").trim();
		state=request.getParameter("state").trim();
		pincode=request.getParameter("pincode").trim();
		mobnum=request.getParameter("mobnum").trim();
		LinkedList<UserSingUpModel> userDetails=new LinkedList<UserSingUpModel>();
		 if((request.getAttribute("unerror")!=null))
		    {
		    	SignUperrors.putAll((HashMap<String,String>)request.getAttribute("unerror"));
		    	
		    }

		//first name 
		if(firstName==null||firstName.length()==0)
		{
			firstName="";
			SignUperrors.put("firstName", "first name can't be left blank");
			
		}
		//last name
		if(lastName==null||lastName.length()==0)
		{
			lastName="";
			SignUperrors.put("lastName", "last name can't be left blank");
			
		}
		//email id
		if(emailId==null||emailId.length()==0)
		{
			emailId="";
			SignUperrors.put("emailId", "last name can't be left blank");
			
		}
		
		//password
		
		if(password==null||password.length()==0)
		{
			password="";
			SignUperrors.put("password", "password can't left empty ");
			
		}
		
		
		
		//repassword
		
		if(!password.equals(repassword) )
		{
			SignUperrors.put("repassword", "password not matching");
			password=repassword="";
						
		}
		
		
		//address
		if(address==null||address.length()==0)
		{
			address="";
			SignUperrors.put("address", "Address can't be left blank");
					
			
		}
		
		//city
		if(city==null||city.length()==0)
		{
			city="";
			SignUperrors.put("city", "City can't be left blank");
			
		}
		
		//state
		if(state==null||state.length()==0)
		{
			state="";
			SignUperrors.put("state", "State can't be left blank");
			
		}
			
		//pincode
		if(pincode==null||pincode.length()==0)
		{
			pincode="";
			SignUperrors.put("pincode", "pincode can't be left blank");
			
		}
		//mobnum
		if(mobnum==null||mobnum.length()==0)
		{
			mobnum="";
			SignUperrors.put("mobnum", "mobnum can't be left blank");
			
		}
		
			
		
		if(SignUperrors.isEmpty())
		{
			userDetails.add(new UserSingUpModel(firstName,lastName,emailId,password,address,city,state,pincode,mobnum));
			request.setAttribute("userDetails", userDetails);
			request.getRequestDispatcher("/UserDetailConnection.do").forward(request, response);
		}
		else
		{
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("emailId", emailId);
			request.setAttribute("password", password);
			request.setAttribute("repassword", repassword);
			request.setAttribute("address", address);
			request.setAttribute("city", city);
			request.setAttribute("state", state);
			request.setAttribute("pincode", pincode);
			request.setAttribute("mobnum", mobnum);
			request.setAttribute("SignUperrors", SignUperrors);
			request.getRequestDispatcher("/UserSignUp.view").forward(request,response);
			

		}
		
	}
	
}
