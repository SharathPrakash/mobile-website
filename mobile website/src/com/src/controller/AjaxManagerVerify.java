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

@WebServlet("/AjaxManagerVerify.do")
public class AjaxManagerVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private String ManagerId;
       private String password;
       private boolean passwordKeywordValid;
   		private boolean passwordValid;
       private boolean ManagerIdCheck;
       public AjaxManagerVerify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		if(request.getParameter("Managerid") != null){
		ManagerId=request.getParameter("Managerid");
		Verification vm=new VerificationClass();
		ManagerIdCheck=vm.managerCheck(ManagerId);
		
			if(!ManagerIdCheck){
				out.write("invalid Manager Id");
				System.out.println("invalid Manager Id");
			}
			
			else{
				out.write("");
			}
		
		}
		else{
			ManagerId="";
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
		doGet(request, response);
	}

}
