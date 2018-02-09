package com.akshay.app.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/studentserv")
public class StudentServlet extends GenericServlet {
	Connection con;
	PreparedStatement pstmt;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		super.init();
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("nm");
		int id = Integer.parseInt(req.getParameter("id"));
		double percentage = Double.parseDouble(req.getParameter("perc"));
		long contact = Long.parseLong(req.getParameter("ct"));
		
		try {
			pstmt = con.prepareStatement("insert into student.registration values(?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.setDouble(4, percentage);
			pstmt.setLong(3, contact);
			
			int a = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*Enumeration<String> enumkeys = req.getParameterNames();
		while (enumkeys.hasMoreElements()) {
			String key = (String) enumkeys.nextElement();
			String value = req.getParameter(key);
			System.out.println(key+" "+value);
		}*/
		String htmlOutPut = "<html><body bgcolor=#cc66cc>"
				+ "<h1 align=center>Welcome...</h1>"
				+ "<p>"
				+ name+"<h3>registered Successfully</h3>"
				+ "<p>"
				+ "<h3><a href=welcome.html>Back</a></h3>"
				+ "</body></html>";
		
		out.write(htmlOutPut);
		out.close();
		
		}
	
	@Override
	public void destroy() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		super.destroy();
	}
}
