package com.src.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sucess
 */
@WebServlet(name = "Sucess.view", urlPatterns = { "/Sucess.view" })
public class Sucess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sucess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		request.getRequestDispatcher("WEB-INF/designcomponents/signUpNav.html").include(request,response);
		//request.getRequestDispatcher("WEB-INF/designcomponents/centralimage.html").include(request,response);//navigation bar support
		out.println("<div class='container'>");
		out.println("<br>");
		out.println("<br>");
		out.println("<h1 align='center'></h1>");
		out.println("<h1 align='center'>wel come </h1>");
		out.println("<h1 align='center'>you are sucessfully registered</h1>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
