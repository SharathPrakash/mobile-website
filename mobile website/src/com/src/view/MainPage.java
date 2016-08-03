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
		
		out.println("<div class='container-fluid'>");
		out.println("<div class='col-md-4 col-xs-12' id='filter'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/SideNav.html").include(request,response);//navigation bar support
		out.println("</div>");
		out.println("<div class='col-md-8'>");
		//main display area
		ResultSet rs=(ResultSet)request.getAttribute("rs");
		if(rs == null){
		out.println("press the filter button");	
		}
		else{
		try{
			int count = 0;
			out.println("<div class='row'>");
			while(count<3){
		
		while(rs.next()){
			
		out.println("<div class='col-md-4 col-xs-12'>");//three in one coloumn
		out.println("<div class='thumbnail'>");
		out.println("<img src='images/mobilethumbnail.png' alt='mobile model name from db'>");
		out.println("<div class='caption'>");
		out.println("<h3>"+rs.getString(3)+"</h3>");
		out.println("<p>"+rs.getString(4)+"</p>");
		out.print("<p>Company Name</p><br>");
		out.println("<p>"+rs.getString(5)+"</p>");
		
		out.print("<p>Screen Size</p><br>");
		out.println("<p>"+rs.getString(6)+"</p>");
		out.print("<p>Front Camera</p>");
		out.println("<p>"+rs.getString(9)+"</p>");
		out.print("<p>rear camera</p>");
		out.println("<p>"+rs.getString(10)+"</p>");
		
		if(session == null){
		out.println("<a class='btn btn-primary' href='UserLogin.view'>Buy</a>");
		}
		else{
			out.println("<a class='btn btn-primary' href='#'>Buy</a>");
		}
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		count++;
			}
			out.println("</div>");
		}
		}
		catch(SQLException exe){
		log("database error");	
		}
		}
		//session.invalidate();
		out.println("</div>");
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
