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

@WebServlet("/UserLoginVerify.do")
public class UserLoginVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
    private Map<String,String> errors=new HashMap<String,String>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginVerify() {
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
		PrintWriter out=response.getWriter();
		username=request.getParameter("username");
		password=request.getParameter("password");
		if(username==null||username.length()==0){
			username="";
			errors.put("username","username cannot be left blank");
		}
		
		else if(password==null||password.length()==0){
			password="";
			errors.put("password","password cannot be left blank");
		}
		else {
			errors.clear();
		}
		
		if(errors.isEmpty()){
			out.println("success");
		}
		
		else{
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/UserLogin.view").forward(request, response);
		}
		
		}
	}


