package org.akshay.app.regform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/studentserv")
public class StudentServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("nm");
		String id = req.getParameter("id");
		String contact = req.getParameter("ct");
		String percentage = req.getParameter("perc");
		String gender = req.getParameter("gender");
		
		String htmlOutPut = "<html>"
				+ "<body>"
				+ "<h1>Welcome...</h1><p>"
				+ name+" <h3>registered Successfully!!!</h3> "
				+"<p>"
				+"<h2><a href='welcome.html'>Back</a></h2>"
				+ "</body>"
				+ "</html>";
		out.write(htmlOutPut);
		out.close();
		
		//SingleTon single = (SingleTon) SingleTon.geSingleTon().getConnection();
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into registration values(?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2,id);
			stmt.setString(3,contact);
			stmt.setString(4, percentage);
			//stmt.setString(5, gender);
			
			
			int a = stmt.executeUpdate();
			System.out.println(a);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
					con=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
