package com.akshay.app.pgm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/searchserv")
public class SearchController extends GenericServlet{
	
	private static final long serialVersionUID = 5342468873184664129L;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			String selectquery = "select * from student.registration2 where stream=?";
			pstmt = con.prepareStatement(selectquery);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		super.init();
	}	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String stream = req.getParameter("stream");
			
		try {
			pstmt.setString(1,stream);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int Id = rs.getInt(1);
				String Name = rs.getString(2);
				double Percentage = rs.getDouble(3);
				long Contact = rs.getLong(4);
				table(rs,out);
			}
			String htmlOutPut = "<html><body bgcolor='yellow'>"
					+ "<p>"
					+ "<h4><a href='search.html'>Search</a> again</h4>"
					+ "</body></html>";

			out.write(htmlOutPut);
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private boolean table(ResultSet rs2, PrintWriter out) throws SQLException {
		int rowcount=0;
		out.println("<font size='10' color='purple'>Student's Data found</font><br>");
        out.println("<P ALIGN='left'><TABLE BORDER=1>");
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        // table header
         out.println("<TR>");
         for (int i = 0; i < columnCount; i++) {
               out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
        }
         out.println("</TR>");
        // the data

        do { 
             rowcount++;
             out.println("<TR>");
             for (int i = 0; i < columnCount; i++) {                
                  out.println("<TD>" + rs.getString(i + 1) + "</TD>");              
             }           
             out.println("</TR>");  
        } while(rs.next());

        out.println("</TABLE></P>");        
        return false;		
	}
	@Override
	public void destroy() {
		if(con!=null)
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		super.destroy();
	}
}
