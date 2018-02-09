package com.akshay.app.uidata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/nameserv")
public class NameServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		/*Fetch UI/Form data*/
		String FirstNm = req.getParameter("fn");
		String lastNm = req.getParameter("ln");
		
		
		String htmloutput="<html>"
				+ "<body bgcolor='#ffcccc'>"
				+ "<h1>Welcome</h1><p>"
				+ FirstNm+" "+lastNm
				+ "<p>"
				+"<h2><a href='message.html'>back</a></h2>"
				+ "</body>"
				+ "</html>";
		out.write(htmloutput);
		out.close();
	}
}
