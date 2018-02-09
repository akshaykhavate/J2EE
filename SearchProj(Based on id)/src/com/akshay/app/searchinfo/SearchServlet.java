package com.akshay.app.searchinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/searchserv")
public class SearchServlet extends GenericServlet{
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			String selectquery = "select * from student.registration2 where id=?";
			pstmt = con.prepareStatement(selectquery);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		super.init();
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		int id = Integer.parseInt(req.getParameter("id"));
		try {
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			String msg = null;
			if(rs.next())
			{
				String name = rs.getString("Name");
				double perc = rs.getDouble("Percentage");
				long contact = rs.getLong("Contact");
				String stream = rs.getString("Stream");
				msg = "<font size='8' color='green'>Student's Data</font><br>"
						+ "<p>"
						+ "<h3>"
						+ id+"<br>"
						+ name+"<br>"
						+ contact+"<br>"
						+ stream
						+"<p>"
						+ "</h3>";
			}
			else
			{
				msg = "<font size='10' color='red'> Data Not Found </font><br>";
			}

			String htmlOutPut = "<html><body bgcolor='yellow'>"
					+ msg
					+ "<p>"
					+ "<a href='search.html'>Search</a> again"
					+ "</body></html>";

			out.write(htmlOutPut);
			out.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
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
