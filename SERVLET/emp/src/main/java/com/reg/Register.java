package com.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		PrintWriter pr = resp.getWriter();
		pr.print("<html><body>");
		pr.print("<h1> Student name is :-"+name+"</h1>");
		pr.print("<h1> Student age is :-"+age+"</h1>");
		pr.print("<h1> Student email is :-"+email+"</h1>");
		pr.print("</body></html>");
		
		
		
		
		
	}

}
