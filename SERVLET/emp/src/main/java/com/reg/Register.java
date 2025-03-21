package com.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name  = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		Cookie ck1= new Cookie("name", name);
		Cookie ck2= new Cookie("email", email);
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		resp.getWriter().print("Cookies Created");
		
		
		
		
		
	}

}
