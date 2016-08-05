package com.src.controller;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.src.services.UserServiceClass;
import com.src.services.UserServicesInterface;

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
	
	HttpSession session= request.getSession(false);
	if(session == null){
		request.getRequestDispatcher("/UserLogin.view").forward(request, response);
				
	}
	else{
		String brand=request.getParameter("brand");
		int rearCamera=Integer.parseInt(request.getParameter("rear camera"));
		int frontCamera=Integer.parseInt(request.getParameter("front camera"));
		int screenSize=Integer.parseInt(request.getParameter("screen size"));
		int price=Integer.parseInt(request.getParameter("pricerange"));
	
		Connection con=(Connection)session.getAttribute("connection");
		UserServicesInterface usi=new UserServiceClass();
		usi.setConnection(con);		
		try{
			System.out.println("Values inside user MainPageController");
			System.out.println(brand);
			System.out.println(rearCamera);
			System.out.println(frontCamera);
			System.out.println(screenSize);
			System.out.println(price);
			
			ResultSet rs=usi.getData(brand,rearCamera,frontCamera,screenSize,price);
		request.setAttribute("rs",rs);
		request.getRequestDispatcher("MainPage.view").forward(request, response);
		}
		catch(SQLException exe){
			exe.printStackTrace();
		}
	}
	}

}
