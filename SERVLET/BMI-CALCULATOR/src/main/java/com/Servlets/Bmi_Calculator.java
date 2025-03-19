package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bmi_Calculator extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	double weight =Double.parseDouble(req.getParameter("weight"));
	float height = Float.parseFloat(req.getParameter("height"));
	ServletConfig sv=getServletConfig();
	String s =sv.getInitParameter("square");
	double  foot=Double.parseDouble(sv.getInitParameter("foot"));
	
	double actual = foot*height;
	PrintWriter pr= resp.getWriter();
	pr.print(weight/(actual*actual));
	
	
	}

}
