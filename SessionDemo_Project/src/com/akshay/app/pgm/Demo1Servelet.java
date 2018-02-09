package com.akshay.app.pgm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Demo1Servelet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String str = req.getParameter("t1");
		System.out.println(str);
		HttpSession session = req.getSession();
		session.setAttribute("t1", str);
		/*RequestDispatcher rd=req.getRequestDispatcher("Demo2");
		rd.forward(req, resp);
*/
		resp.sendRedirect("Demo2Servlet");
	}
	
}
