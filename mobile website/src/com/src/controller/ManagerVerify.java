package com.src.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.ManagerModel;


@WebServlet("/ManagerVerify.do")
public class ManagerVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ManagerId;
	private String password;
    private Map<String,String> errors=new HashMap<String,String>();

	
	public ManagerVerify() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerId=request.getParameter("Managerid").trim();
		password=request.getParameter("password").trim();
		//checking for errors in email
		if(ManagerId==null||ManagerId.length()==0){
			ManagerId="";
			errors.put("Managerid","manager id cannot be left blank");
			//checking for errors in password when there is error in email
			if(password==null||password==""){
				password="";
				errors.put("passwordManager","password cannot be left blank");
			}
			
			else if(password.length()<3){
				password="";
				errors.put("passwordManager","password must be atleast 3 charecters");
			}
		
		}
		//checking for error in password when no error in email
		else if(password==null||password==""){
			password="";
			errors.put("Managerid","");
			errors.put("passwordManager","password cannot be left blank");
		}
		
		else if(password.length()<3){
			password="";
			errors.put("Managerid","");
			errors.put("passwordManager","password must be atleast 3 charecters");
		}
		//clearing error if stored from previous request
		else {
			errors.clear();
		}
		
		if(errors.isEmpty()){
			//checking email and password  in database
			ManagerModel data=new ManagerModel();
			data.setManagerId(request.getParameter("Managerid"));
			data.setPassword(request.getParameter("password"));
			request.setAttribute("data", data);
			request.getRequestDispatcher("/ManagerConnection.do").forward(request,response);
		}
		
		else{
			//sending errors to the front page
			request.setAttribute("ManagerId",ManagerId);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/ManagerLogin.view").forward(request, response);
		}
		
		}


}
