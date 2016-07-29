package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out =response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);//imports online bootstrap libraries
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("WEB-INF/designcomponents/navbar.html").include(request,response);//navigation bar support
		out.println("<div class='container-fluid'>");
		out.println("<div class='col-md-4 col-xs-12' id='filter'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/SideNav.html").include(request,response);//navigation bar support
		out.println("</div>");
		out.println("<div class='col-md-8'>");
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println();
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
