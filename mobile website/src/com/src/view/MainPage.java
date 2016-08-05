package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainPage.view")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		PrintWriter out =response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);//imports online bootstrap libraries
		out.println("</head>");
		out.println("<body>");
		if(session ==null){
		request.getRequestDispatcher("WEB-INF/designcomponents/navbar.html").include(request,response);//navigation bar support
		}
		else{
		request.getRequestDispatcher("WEB-INF/designcomponents/navbarlogout.html").include(request,response);//navigation bar support
		}
		
		request.getRequestDispatcher("WEB-INF/designcomponents/centralimage.html").include(request,response);//navigation bar support
		
		out.println("<div class='container'>");
	
		//main display area
		ResultSet rs=(ResultSet)request.getAttribute("rs");
		if(rs == null){
		out.println("<h2>Welcome to the Mobile Store Search for the mobile you want using the filter option above</h2>");	
		}
		else{
		try{
			
		while(rs.next()){
			
		out.println("<div class='col-md-offset-2 col-md-8'>");
		out.println("<div class='thumbnail'>");
		out.println("<img class='img-responsive' src="+rs.getString(11)+" style='width:50%'>");
		out.println("<div class='caption'>");
		out.println("<h2>"+rs.getString(3)+"</h2>");
		out.println("<h4>"+rs.getString(4)+"</h4>");
		out.println("<table>");
		out.println("<tr>");
		out.print("<td><h4>Company Name:- &nbsp;</h4></td>");
		out.println("<td><h4>"+rs.getString(5)+"</h4></td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.print("<td><h4>Screen Size</h4></td>");
		out.println("<td><h4>"+rs.getString(6)+" inches</h4></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.print("<td><h4>Front Camera</h4></td>");
		out.println("<td><h4>"+rs.getString(9)+" Mp</h4></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.print("<td><h4>Rear Camera</h4></td>");
		out.println("<td><h4>"+rs.getString(10)+" Mp</h4></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</br>");
		if(session == null){
		out.println("<a class='btn btn-primary' href='UserLogin.view'><h4>Buy</h4></a>");
		}
		else{
			if(Integer.parseInt(rs.getString(12))==0){
				out.println("<a class='btn btn-primary disabled' href='#'>out of stock</a>");
			}
			else{
			out.println("<a class='btn btn-primary' href='#'>Buy</a>");
			}
		}
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
			}
	
		}
		
		catch(SQLException exe){
		log("database error");	
		}
		}
		//session.invalidate();
		out.println("</div>");
		
		out.println("<footer>");
		request.getRequestDispatcher("WEB-INF/designcomponents/Footer.html").include(request,response);//navigation bar support
		out.println("</footer>");
		out.println("</body>");
		out.println("</html>");
		response.setHeader("Cache-control","no-cache,no-store");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires", "-1");
		
	}
	
}
