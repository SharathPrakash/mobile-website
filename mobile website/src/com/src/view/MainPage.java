package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;

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
		out.println("<div class='col-md-4 col-xs-12'>");//three in one coloumn
		out.println("<div class='thumbnail'>");
		out.println("<img src='images/mobilethumbnail.png' alt='mobile model name from db'>");
		out.println("<div class='caption'>");
		out.println("<h3>Mobile name retrived from db</h3>");
		out.println("<p>mobile specs will also be retrived from database when the search result is submitted</p>");
		if(session == null){
		out.println("<a class='btn btn-primary' href='UserLogin.view'>Buy</a>");
		}
		else{
			out.println("<a class='btn btn-primary' href='#'>Buy</a>");
		}
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='col-md-4 col-xs-12'>");//three in one column
		out.println("<div class='thumbnail'>");
		out.println("<img src='images/mobilethumbnail.png' alt='mobile model name from db'>");
		out.println("<div class='caption'>");
		out.println("<h3>Mobile name retrived from db</h3>");
		out.println("<p>mobile specs will also be retrived from database when the search result is submitted</p>");
		out.println("<a class='btn btn-primary' href='#'>Buy</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class='col-md-4 col-xs-12'>");//three in one coloumn
		out.println("<div class='thumbnail'>");
		out.println("<img src='images/mobilethumbnail.png' alt='mobile model name from db'>");
		out.println("<div class='caption'>");
		out.println("<h3>Mobile name retrived from db</h3>");
		out.println("<p>mobile specs will also be retrived from database when the search result is submitted</p>");
		out.println("<a class='btn btn-primary' href='#'>Buy</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
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
