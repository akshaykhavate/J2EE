package com.akshay.loginapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginController extends GenericServlet {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		/* Fetch declarative data/init parameters*/
		final String DRIVER = config.getInitParameter("dbdriver");
		final String URL = config.getInitParameter("dburl");
		final String USER = config.getInitParameter("dbun");
		final String PASS = config.getInitParameter("dbpwd");

		try {
			/* Load and register the driver*/
			Class.forName(DRIVER);
			/* establish the connection*/
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("---con---"+con);
			String query = "select name from j2ee.user where un=? & pwd=?";
			pstmt = con.prepareStatement(query);
			System.out.println("---pstmt----"+pstmt);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		/* UI/FORM Data/parameters */
		String uiun = req.getParameter("un");
		String uiPwd = req.getParameter("pwd");
		String msg =" ";
		
		try {
			/* set ui data to placeholders*/
			pstmt.setString(1, uiun);
			pstmt.setString(2, uiPwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				/*validation success*/
				String Actualname = rs.getString("name");
				msg = "<font size='5' color='green'>Welcome.."+Actualname+"</font>";
			}else
			{
				msg = "<font size='5' color='red'>Invalid User</font>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*Presentation logic*/
		PrintWriter out = resp.getWriter();
		String htmlOutPut = "<html><body color='yellow'>"
				+msg
				+ "</body></html>";
		out.write(htmlOutPut);
		out.close();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
