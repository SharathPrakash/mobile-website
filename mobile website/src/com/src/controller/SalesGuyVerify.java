package com.src.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.SalesGuyModel;


@WebServlet("/SalesGuyVerify.do")
public class SalesGuyVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String employeeId;
	private String password;
    private Map<String,String> errors=new HashMap<String,String>();

    public SalesGuyVerify() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//taking input parameters
		employeeId=request.getParameter("employeeid").trim();
		password=request.getParameter("password").trim();
		//checking for errors in email
		if(employeeId==null||employeeId.length()==0){
			employeeId="";
			errors.put("employeeid","employee id cannot be left blank");
			//checking for errors in password when there is error in email
			if(password==null||password==""){
				password="";
				errors.put("password","password cannot be left blank");
			}
			
			else if(password.length()<3){
				password="";
				errors.put("password","password must be atleast 3 charecters");
			}
		
		}
		//checking for error in password when no error in email
		else if(password==null||password==""){
			password="";
			errors.put("employeeId","");
			errors.put("password","password cannot be left blank");
		}
		
		else if(password.length()<3){
			password="";
			errors.put("employeeId","");
			errors.put("password","password must be atleast 3 charecters");
		}
		//clearing error if stored from previous request
		else {
			errors.clear();
		}
		
		if(errors.isEmpty()){
			//checking email and password  in database
			SalesGuyModel data=new SalesGuyModel();
			data.setEmployeeId(request.getParameter("employeeid"));
			data.setPassword(request.getParameter("password"));
			request.setAttribute("data", data);
			request.getRequestDispatcher("/SalesGuyConnection.do").forward(request,response);
		}
		
		else{
			//sending errors to the front page
			request.setAttribute("employeeId",employeeId);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/SalesGuyLogin.view").forward(request, response);
		}
		
		}

}
