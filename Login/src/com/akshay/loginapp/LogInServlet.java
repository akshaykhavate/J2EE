package com.akshay.loginapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String un = req.getParameter("nm");
		String pwd = req.getParameter("pwd");
		
		RequestDispatcher rd = req.getRequestDispatcher("error.html");
		
		if(un.equals("admin")&& pwd.equals("admin")){
			resp.sendRedirect("success.html");
		}
		else{
			rd.forward(req, resp);
			//resp.sendRedirect("error.html");
		}
		
	}
}
