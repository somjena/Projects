package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	int age= Integer.parseInt(req.getParameter("age"));
	String query="insert into admin values(?,?,?)";
	Connection con;
	Object o= getServletContext().getAttribute("Url");
	System.out.println(o);
	
	try {
		Class.forName("org.postgresql.Driver");
		con =DriverManager.getConnection((String)o);
		PreparedStatement pr= con.prepareStatement(query);
		pr.setString(1, name);
		pr.setString(2, email);
		pr.setInt(3, age);
		if(pr.executeUpdate()>0) {
			resp.sendRedirect("login.html");
		}
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	}

}
