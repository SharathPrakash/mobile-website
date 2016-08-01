package com.src.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.MainPageModel;

/**
 * Servlet implementation class MainPageController
 */
@WebServlet("/MainPageController.do")
public class MainPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainPageController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out =response.getWriter();
	HttpSession session= request.getSession(false);
	if(session == null){
		request.getRequestDispatcher("/UserLogin.view").forward(request, response);
				
	}
	else{
		String brand=request.getParameter("brand");
		String[] rearCamera=request.getParameterValues("rearcamera");
		String[] frontCamera=request.getParameterValues("frontcamera");
		String[] screenSize=request.getParameterValues("screensize");
		String price=request.getParameter("pricerange");
	
		for(String s:rearCamera){
		out.println(s);
		}
		
		for(String s:frontCamera){
			out.println(s);
			}
		
		for(String s:screenSize){
			out.println(s);
			}
			
			
	}
	}

}
