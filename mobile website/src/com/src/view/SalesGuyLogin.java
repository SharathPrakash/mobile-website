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

@WebServlet("/SalesGuyLogin.view")
public class SalesGuyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,String> errors=new HashMap<>();
	
    public SalesGuyLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//error transporting from verification page
		Map<String, String>errors=new HashMap<>();
		 String employeeId="";
		 
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
		request.getRequestDispatcher("WEB-INF/designcomponents/employeeimage.html").include(request,response);//navigation bar support
		
		out.println("<div class='container'>");
		out.println("<form method='post' action='SalesGuyVerify.do'>");
		out.println("<div class='col-md-5 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h3>Employee-Login-Portal</h3></th>");
		out.println("<br>");
		//displaying message about invalid email or password
		if(request.getAttribute("invalid")==null){
		out.println("");
		}
		else{
			out.println("<th><h5 style='color:red'> <span class='glyphicon glyphicon-remove-circle'></span> &nbsp"+request.getAttribute("invalid")+"</h5></th>");
		}
		//-----------------------------------------------//
		//email retention code
		

		if(request.getAttribute("employeeId")==null){
		employeeId="";
		}
		else
		{
			employeeId=(String)request.getAttribute("employeeId");
		}
		//---------------------------------------------//
		
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Employee-Id");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='employeeid' value="+employeeId+">");
		out.println("</td>");
		out.println("<td>");
		//---------------------------//
		//email error reporting 
		if(!errors.isEmpty()){
			if(errors.get("employeeid")==null){
			out.println("");
			}
		else{
			out.println("<p style='color:red'>"+errors.get("employeeid")+"</p>");
			errors.put("employeeid","");
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
		out.println("<input type='password' id='password' name='password'>");
		out.println("</td>");
		
		out.println("<td>");
		//-------------------------------------//
		//password error reporting
		if(!errors.isEmpty()){
			
			if(errors.get("password") == null||errors.get("password")==""){
				out.println("<span class='glyphicon glyphicon-ok' style='color:green'></span>");
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
		//submit button
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type='submit' value='Login'>");
		out.println("</td>");
		out.println("<td>");
		out.println("<a href='ManagerLogin.view'>Manager Login</a>");
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


