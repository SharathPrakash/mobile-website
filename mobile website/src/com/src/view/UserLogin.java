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
    Map<String,String> errors=new HashMap();
	public UserLogin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Map<String, String>errors=new HashMap<>();
		 String email="";
		if(!(request.getAttribute("errors") == null)){
			errors.putAll((HashMap<String,String>)request.getAttribute("errors"));
		}
		else{
			//do nothing
		}
		if(request.getAttribute("email")==null){
		email="";
		}
		else
		{
			email=(String)request.getAttribute("email");
		}
		out.println("<!Doctype html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/navbar.html").include(request,response);
		out.println("<div class='container'>");
		out.println("<form method='post' action='UserLoginVerify.do'>");
		out.println("<div class='col-md-offset-3 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h2>Login</h2></th>");
		out.println("<tr>");
		out.println("<td>");
		out.println("E-mail");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='email' value="+email+">");
		out.println("</td>");
		out.println("<td>");
		if(!errors.isEmpty()){
		String usernameError=errors.get("email");
		if(usernameError == null){
			out.println("");
		}
		else{
			out.println(usernameError);
		}
		}
		else{
			out.println("");
		}
		out.println("</td>");
		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("password");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='password' name='password'>");
		out.println("</td>");
		
		out.println("<td>");
		if(!errors.isEmpty()){
			String passwordError=errors.get("password");
			if(passwordError == null){
				out.println("");
			}
			else{
				out.println(passwordError);
			}
			
		}
		else{
			out.println("");
		}
		out.println("</td>");
		
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
		request.getRequestDispatcher("WEB-INF/designcomponents/Footer.html").include(request,response);
		out.println("</footer>");
	}

}
