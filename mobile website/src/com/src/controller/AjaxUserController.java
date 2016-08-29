package com.src.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.services.Verification;
import com.src.services.VerificationClass;

@WebServlet("/AjaxUserController.do")
public class AjaxUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email="";
	private String password="";
	private boolean emailKeywordValid;
	private boolean emailStringValid;
	private boolean passwordKeywordValid;
	private boolean passwordValid;
    public AjaxUserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		if(request.getParameter("email") != null){
		email=request.getParameter("email");
		Verification vf=new VerificationClass();
		emailKeywordValid=vf.keywordCheck(email);
	
		if(!emailKeywordValid){
			out.write("invalid keyword");
			System.out.println("invalid keyword");
		}
		else{
			out.write("");
			emailStringValid=vf.emailCheck(email);
			if(!emailStringValid){
			out.write("invalid email");
			}
			else{
			out.write("");	
			}
		}
	}
	else{
		email="";
	}
	
	if(request.getParameter("password") != null){
		password=request.getParameter("password");
		Verification vp=new VerificationClass();
		passwordKeywordValid=vp.keywordCheck(password);
		passwordValid=vp.passwordCount(password);
		if(!passwordValid){
			out.write("password must be more than 4 charecters");
		}
		else{
		if(!passwordKeywordValid){
			out.write("invalid keyword");
			System.out.println("invalid keyword");
		}
		else{
			out.write("");
		}
		}
	}
	else{
		password="";
	}
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
