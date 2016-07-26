package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserLogin.view")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Map<String,String> errors=new HashMap<>();
	public UserLogin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//error transporting from verification page
		Map<String, String>errors=new HashMap<>();
		 String email="";
		if(!(request.getAttribute("errors") == null)){
			errors.putAll((HashMap<String,String>)request.getAttribute("errors"));
		}
		else{
			errors.clear();
		}
		//------------------------------------------//
		out.println("<!Doctype html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);//imports online bootstrap libraries
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/navbar.html").include(request,response);//navigation bar support
		out.println("<div class='container'>");
		out.println("<form method='post' action='UserLoginVerify.do'>");
		out.println("<div class='col-md-offset-3 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h2>Login</h2></th>");
		out.println("<br>");
		//displaying message about invalid email or password
		if(request.getAttribute("invalid")==null){
		out.println("");
		}
		else{
			out.println("<th><h5 style='color:red'>"+request.getAttribute("invalid")+"</h5></th>");
		}
		//-----------------------------------------------//
		//email retention code
		

		if(request.getAttribute("email")==null){
		email="";
		}
		else
		{
			email=(String)request.getAttribute("email");
		}
		//---------------------------------------------//
		
		
		out.println("<tr>");
		out.println("<td>");
		out.println("E-mail");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='email' value="+email+">");
		out.println("</td>");
		out.println("<td>");
		//---------------------------//
		//email error reporting 
		if(!errors.isEmpty()){
			if(errors.get("email")==null){
			out.println(" ");
			}
		else{
			out.println("<p style='color:red'>"+errors.get("email")+"</p>");
			errors.put("email","");
			}
		}
		else{
			out.println("");
		}
		out.println("</td>");
		//-------------------------------//
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("password");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='password' name='password'>");
		out.println("</td>");
		
		out.println("<td>");
		//-------------------------------------//
		//password error reporting
		if(!errors.isEmpty()){
			
			if(errors.get("password") == null||errors.get("password")==""){
				out.println("");
			}
			else{
				out.println("<p style='color:red'>"+errors.get("password")+"</p>");
				errors.put("password","");
			}
			
		}
		else{
			out.println("");
			
		}
		out.println("</td>");
		//-------------------------------------//
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type='submit' value='Login'>");
		out.println("</td>");
		out.println("<td>");
		out.println("<a href='UserSignup.view'>New User?</a>");
		out.println("</td>");

		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		out.println("<footer>");
		//getting footer from footer.html
		request.getRequestDispatcher("WEB-INF/designcomponents/Footer.html").include(request,response);
		out.println("</footer>");
	}

}
