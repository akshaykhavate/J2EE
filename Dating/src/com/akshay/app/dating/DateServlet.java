package com.akshay.app.dating;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Timer;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/akshay")
public class DateServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		Date d = new Date();
		String outputContent = "<html><body><h1>Welcome to Servlet Akshay :)<p>"+d+"</h1></body></html>";
		PrintWriter out = resp.getWriter();
		out.write(outputContent);
	}
}
