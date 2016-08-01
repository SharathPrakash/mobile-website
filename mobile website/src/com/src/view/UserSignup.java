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
@WebServlet("/UserSignup.view")
public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignup() {
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
				Map<String, String>SignUperrors=new HashMap<String,String>();
				String first_name,last_name,password,repassword,email_ID,address,city,state,pincode,mobnum;
				
				if(!(request.getAttribute("SignUperrors") == null)){
					SignUperrors.putAll((HashMap<String,String>)request.getAttribute("SignUperrors"));
		
					
				}
				
					
				else{
						SignUperrors.clear();			
					}
				
				
		
		
		out.println("<!Doctype html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/navbar.html").include(request,response);
		request.getRequestDispatcher("WEB-INF/designcomponents/centralimage.html").include(request,response);//navigation bar support
		out.println("<div class='container'>");
		out.println("<form method='post' action='UserSignUpVerify.do'>");
		out.println("<div class='col-md-offset-3 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h2>Sign Up</h2></th>");
		
		//first name
		out.println("<tr>");
			out.println("<td>");
			out.println("First name");
			out.println("</td>");
			if(request.getAttribute("first_name")==null){
				first_name="";
				}
				else
				{
					first_name=(String)request.getAttribute("efirst_name");
				}
			
			out.println("<td>");
			out.println("<input type='text' name='first_name' value="+first_name+">");
			out.println("</td>");
			out.println("<td>");
			
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("efirst_name")==null){
					out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
					
					
					
							}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("efirst_name")+"</p>");
				SignUperrors.put("efirst_name","");
				
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
			if(request.getAttribute("last_name")==null){
				last_name="";
				}
				else
				{
					last_name=(String)request.getAttribute("first_name");
				}
			
			out.println("<td>");
			out.println("<input type='text' name='last_name'value="+last_name+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("last_name")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("last_name")+"</p>");
				SignUperrors.put("last_name","");
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
			if(request.getAttribute("email_ID")==null){
				email_ID="";
				}
				else
				{
					email_ID=(String)request.getAttribute("email_ID");
				}
			
			out.println("<td>");
			out.println("<input type='text' name='email_ID' value="+email_ID+">");
			out.println("</td>");
			out.println("<td>");
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("email_ID")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("email_ID")+"</p>");
				SignUperrors.put("email_ID","");
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
			if(request.getAttribute("password")==null){
				password="";
				}
				else
				{
					password=(String)request.getAttribute("password");
				}
			out.println("<td>");
			out.println("<input type='text' name='password'>");
			out.println("</td>");
			out.println("<td>");
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("password")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("password")+"</p>");
				SignUperrors.put("password","");
				}
			}
			else{
				out.println("");
			}
			out.println("</td>");
		out.println("</tr>");
		
		
		//repassword
		out.println("<tr>");
			out.println("<td>");
			out.println("Confirm Password");
			out.println("</td>");
			if(request.getAttribute("repassword")==null){
				repassword="";
				}
				else
				{
					repassword=(String)request.getAttribute("repassword");
				}
			
			out.println("<td>");
			out.println("<input type='text' name='repassword'>");
			out.println("</td>");
			out.println("<td>");
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("repassword")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("repassword")+"</p>");
				SignUperrors.put("repassword","");
				}
			}
			else{
				out.println("");
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
		if(!SignUperrors.isEmpty()){
			if(SignUperrors.get("address")==null){
			out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
			}
		else{
			out.println("<p style='color:red'>"+SignUperrors.get("address")+"</p>");
			SignUperrors.put("address","");
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
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("city")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("city")+"</p>");
				SignUperrors.put("city","");
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
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("state")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("state")+"</p>");
				SignUperrors.put("state","");
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
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("pincode")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("pincode")+"</p>");
				SignUperrors.put("pincode","");
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
			if(!SignUperrors.isEmpty()){
				if(SignUperrors.get("mobnum")==null){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
				}
			else{
				out.println("<p style='color:red'>"+SignUperrors.get("mobnum")+"</p>");
				SignUperrors.put("mobnum","");
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
