package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSignup
 */
@WebServlet("/UserSignUp.view")
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUp() {
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
		PrintWriter out = response.getWriter();
		//error transporting from verification page
				Map<String,String>SignUpErrors=new HashMap<String,String>();
				
				String firstName,lastName,emailId,password,repassword,address,city,state,pincode,mobnum;
				
				if(!(request.getAttribute("SignUperrors") == null)){
					SignUpErrors.putAll((HashMap<String,String>)request.getAttribute("SignUperrors"));
		
					
				}
				else{
						SignUpErrors.clear();
						
					}
				
				
		
		out.println("<!Doctype html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/signUpNav.html").include(request,response);
		//request.getRequestDispatcher("WEB-INF/designcomponents/centralimage.html").include(request,response);//navigation bar support
		out.println("<div class='container'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<form method='post' action='UserSignUpVerify.do'>");
		out.println("<div class='col-md-offset-3 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h2>Sign Up</h2></th>");
		
		//first name
		out.println("<tr>");
			out.println("<td>");
			out.println("First name");
			out.println("</td>");
			if(request.getAttribute("firstName")==null){
				firstName="";
				}
				else
				{
					firstName=(String)request.getAttribute("firstName");
				}

			out.println("<td>");
			out.println("<input type='text' name='firstName' value="+firstName+">");
			out.println("</td>");
			out.println("<td>");
			
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("firstName")==null){
					out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
					
					
							}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("firstName")+"</p>");
				SignUpErrors.put("firstName","");
				
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		
		
		//last name
		out.println("<tr>");
			out.println("<td>");
			out.println("Last name");
			out.println("</td>");
			if(request.getAttribute("lastName")==null){
				lastName="";
				}
				else
				{
					lastName=(String)request.getAttribute("lastName");
				}

			out.println("<td>");
			out.println("<input type='text' name='lastName' value="+lastName+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("lastName")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("lastName")+"</p>");
				SignUpErrors.put("lastName","");
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		
		
		//email id
		out.println("<tr>");
			out.println("<td>");
			out.println("Email ID");
			out.println("</td>");
			if(request.getAttribute("emailId")==null){
				emailId="";
				}
				else
				{
					emailId=(String)request.getAttribute("emailId");
				}

			out.println("<td>");
			out.println("<input type='text' name='emailId' value="+emailId+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("emailId")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("emailId")+"</p>");
				SignUpErrors.put("emailId","");
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		
		
		//password
		out.println("<tr>");
			out.println("<td>");
			out.println("Password");
			out.println("</td>");
			

			out.println("<td>");
			out.println("<input type='password' name='password'>");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("password")!=null)
				{
					out.println("<p style='color:red'>"+SignUpErrors.get("password")+"</p>");
					SignUpErrors.put("password","");
					
				}
			}
			
			out.println("</td>");
		out.println("</tr>");
		
		
		//repassword
		out.println("<tr>");
			out.println("<td>");
			out.println("Confirm Password");
			out.println("</td>");
			out.println("<td>");
			out.println("<input type='password' name='repassword'>");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("repassword")!=null)
				{
					out.println("<p style='color:red'>"+SignUpErrors.get("repassword")+"</p>");
					SignUpErrors.put("repassword","");
					
				}
			}
			
			out.println("</td>");
		out.println("</tr>");
		
		
		//address
		out.println("<tr>");
			out.println("<td>");
			out.println("Address");
			out.println("</td>");
			if(request.getAttribute("address")==null){
				address="";
				}
				else
				{
					address=(String)request.getAttribute("address");
				}

			out.println("<td>");
			out.println("<input type='text'name='address' value="+address+">");
		out.println("</td>");
		out.println("<td>");
		if(!SignUpErrors.isEmpty()){
			if(SignUpErrors.get("address")==null){
			out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
			}
		else{
			out.println("<p style='color:red'>"+SignUpErrors.get("address")+"</p>");
			SignUpErrors.put("address","");
			}
		}
		else{
			
			out.println("");
		}
		out.println("</td>");
		out.println("</tr>");
		
		
		//city
		out.println("<tr>");
			out.println("<td>");
			out.println("City");
			out.println("</td>");
			if(request.getAttribute("city")==null){
				city="";
				}
				else
				{
					city=(String)request.getAttribute("city");
				}
			
			out.println("<td>");
			out.println("<input type='text' name='city' value="+city+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("city")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("city")+"</p>");
				SignUpErrors.put("city","");
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		
		
		//state
		out.println("<tr>");
			out.println("<td>");
			out.println("State");
			out.println("</td>");
			if(request.getAttribute("state")==null){
				state="";
				}
				else
				{
					state=(String)request.getAttribute("state");
				}
			
			out.println("<td>");
			out.println("<input type='text' name='state' value="+state+">");
			out.println("</td>");
			out.println("<td>");
		if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("state")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("state")+"</p>");
				SignUpErrors.put("state","");
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		

		//pincode
		out.println("<tr>");
			out.println("<td>");
			out.println("Pincode");
			out.println("</td>");
			if(request.getAttribute("pincode")==null){
				pincode="";
				}
				else
				{
					pincode=(String)request.getAttribute("pincode");
				}
		
			out.println("<td>");
			out.println("<input type='text' name='pincode' value="+pincode+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("pincode")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("pincode")+"</p>");
				SignUpErrors.put("pincode","");
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		

		//mobnum
		out.println("<tr>");
			out.println("<td>");
			out.println("Mobile number");
			out.println("</td>");
			if(request.getAttribute("mobnum")==null){
				mobnum="";
				}
				else
				{
					mobnum=(String)request.getAttribute("mobnum");
				}
	
			out.println("<td>");
			out.println("<input type='text' name='mobnum' value="+mobnum+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUpErrors.isEmpty()){
				if(SignUpErrors.get("mobnum")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUpErrors.get("mobnum")+"</p>");
				SignUpErrors.put("mobnum","");
				}
			}

			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		
		
		//login
			out.println("<tr>");
			out.println("<td>");
			out.println("<a href='UserLogin.view'>Login </a>");
			out.println("</td>");
		
			out.println("<td>");
			out.println("<input type='submit' value='SignUp'>");
			
			out.println("</td>");
			
		out.println("</tr>");
		
		out.println("</table>");
		
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		
		out.println("<footer>");
		request.getRequestDispatcher("WEB-INF/designcomponents/Footer.html").include(request,response);
		out.println("</footer>");
	}

}
