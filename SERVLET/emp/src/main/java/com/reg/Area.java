package com.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Area extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletConfig sv=getServletConfig();
	  int var=Integer.parseInt(sv.getInitParameter("pi")) ;
	  int val =Integer.parseInt( req.getParameter("var"));
	  PrintWriter pr= resp.getWriter();
	  pr.print("<html><body>");
	  pr.print("<h1>"+var*val+"</h1>");
	  pr.print("</body></html>");
	 
	
	}

}
