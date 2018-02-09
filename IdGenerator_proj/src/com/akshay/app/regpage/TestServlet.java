package com.akshay.app.regpage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regserv")
public class TestServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		
		String name = user.setName(req.getParameter("name"));
		String phone = user.setPhone(req.getParameter("phone"));
		String email = user.setEmail(req.getParameter("email"));
		String gender = user.setGender(req.getParameter("gender"));
		
		UserDAO ud = new UserDAO();
		ud.addUser(user);
	}
}
