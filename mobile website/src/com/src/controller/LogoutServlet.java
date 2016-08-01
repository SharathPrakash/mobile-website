package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet.view")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession(false);
	if(session==null){
	request.getRequestDispatcher("UserLogin.view").forward(request, response);
	
	}
	else{
		response.setHeader("Cache-control","no-cache,no-store");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires", "-1");
		session.invalidate();
		request.setAttribute("logout","you have successfully loged out");
		request.getRequestDispatcher("UserLogin.view").forward(request, response);
			
		
	}
	}

}
