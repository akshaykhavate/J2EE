package com.akshay.app.pgm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String msg = "<html><body>"
				+ "<p>"
				+ "<h1>"
				+ "Welcome to web.xml Configuration"
				+ "</body></html>";
		
		PrintWriter out = resp.getWriter();
		out.write(msg);
	}
	
}
