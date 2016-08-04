package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ManagerPage.view")
public class ManagerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ManagerPage() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession(false);
		if(session == null){
			request.getRequestDispatcher("/ManagerLogin.view").forward(request, response);
		}
		else{
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		request.getRequestDispatcher("WEB-INF/designcomponents/title.html").include(request,response);//imports online bootstrap libraries
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='container'>");
		request.getRequestDispatcher("WEB-INF/designcomponents/ManagerNav.html").include(request,response);//navigation bar support
		
		out.println("<div class='container-fluid'>");
		out.println("<div class='row'>");
		
		out.println("<div class='col-md-4 col-xs-12' id='buttons'>");
		out.println("<h2><a href=''>Add An Employee <span class='glyphicon glyphicon-user'></span><span style='color:green' class='glyphicon glyphicon-plus'></span></a></h2>");
		out.println("</div>");
		
		out.println("<div class='col-md-4 col-xs-12' id='buttons'>");
		out.println("<h2> <a href=''>Remove An Employee <span class='glyphicon glyphicon-user'></span><span style='color:red' class='glyphicon glyphicon-minus'></span></a></h2>");
		out.println("</div>");
		
		out.println("<div class='col-md-4 col-xs-12' id='buttons'>");
		out.println("<h2><a href=''>Sales Graph <span class='glyphicon glyphicon-signal'></a></h2>");
		out.println("</div>");
		
		
		out.println("</div>");
		out.println("</div>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<footer>");
		request.getRequestDispatcher("WEB-INF/designcomponents/Footer.html").include(request,response);//navigation bar support
		out.println("</footer>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		response.setHeader("Cache-control","no-cache,no-store");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires", "-1");
	
		}
	}

}
