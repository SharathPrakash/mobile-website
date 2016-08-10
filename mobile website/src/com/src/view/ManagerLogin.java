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

@WebServlet("/ManagerLogin.view")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ManagerLogin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//error transporting from verification page
		Map<String, String>errors=new HashMap<>();
		 
		 String managerId="";
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
		out.println("<form method='post' action='ManagerVerify.do'>");
		out.println("<div class='col-md-5 col-xs-12' id='UserLogin'>");
		out.println("<table class='table-condensed' >");
		out.println("<th><h3>Manager-Login-Portal</h3></th>");
		out.println("<br>");
		//displaying message about invalid email or password
		if(request.getAttribute("invalidManager")==null){
		out.println("");
		}
		else{
			out.println("<th><h5 style='color:red'> <span class='glyphicon glyphicon-remove-circle'></span> &nbsp"+request.getAttribute("invalidManager")+"</h5></th>");
		}
		//-----------------------------------------------//
		//email retention code
		

		if(request.getAttribute("ManagerId")==null){
		managerId="";
		}
		else
		{
			managerId=(String)request.getAttribute("ManagerId");
		}
		//---------------------------------------------//
		
		
		out.println("<tr>");
		out.println("<td>");
		out.println("Manager-Id");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='text' name='Managerid' value="+managerId+">");
		out.println("</td>");
		out.println("<td>");
		//---------------------------//
		//email error reporting 
		if(!errors.isEmpty()){
			if(errors.get("Managerid")==null){
			out.println("");
			}
		else{
			out.println("<p style='color:red'>"+errors.get("Managerid")+"</p>");
			errors.put("Managerid","");
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
			
			if(errors.get("passwordManager") == null||errors.get("passwordManager")==""){
				out.println("<p id='jpwd' style='color:red'></p>");
			}
			else{
				out.println("<p style='color:red'>"+errors.get("passwordManager")+"</p>");
				errors.put("password","");
			}
			
		}
		else{
			out.println("<p id='jpwd' style='color:red'></p>");
			
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
		out.println("<a href='SalesGuyLogin.view'>Employee Login</a>");
		out.println("</td>");
		out.println("</tr>");

		
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
