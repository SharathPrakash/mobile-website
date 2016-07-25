package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		
		out.println("<!Doctype html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);
		out.println("</head>");
		out.println("<body bgcolor='white'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/navbar.html").include(request,response);
		out.println("<div class='container'>");
		out.println("<form method='post' action='UserSignupVerify.do'>");
		out.println("<div class='col-md-offset-3 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h2>Sign Up</h2></th>");
		out.println("<tr>");
		out.println("<td>");
		out.println("First name");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='First name'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Last name");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Last name'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Email ID");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Email ID'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Password");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Password'>");
		out.println("</td>");
		out.println("</tr>");out.println("<tr>");
		out.println("<td>");
		out.println("Confirm Password");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Repassword'>");
		out.println("</td>");
		out.println("</tr>");out.println("<tr>");
		out.println("<td>");
		out.println("Address");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Address'>");
		out.println("</td>");
		out.println("</tr>");out.println("<tr>");
		out.println("<td>");
		out.println("City");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='City'>");
		out.println("</td>");
		out.println("</tr>");out.println("<tr>");
		out.println("<td>");
		out.println("State");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='State'>");
		out.println("</td>");
		out.println("</tr>");out.println("<tr>");
		out.println("<td>");
		out.println("Pincode");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Pincode'>");
		out.println("</td>");
		out.println("</tr>");
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
