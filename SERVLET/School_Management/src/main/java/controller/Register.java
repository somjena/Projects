package controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Student;
import service.StudentService;
@WebServlet("/register")
public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id=Integer.parseInt(req.getParameter("id"));
		 String name = req.getParameter("name");
		 int age = Integer.parseInt(req.getParameter("age"));
		 String gender = req.getParameter("gender");
		 System.out.println(" idd = "+id +" name ="+name+ " age="+age +" gender="+gender);
		 StudentService service = new StudentService();
		 Student s1 = new Student();
		 s1.setId(id);
		 s1.setName(name);
		 s1.setAge(age);
		 s1.setGender(gender);
		 int res =service.register(s1);
		 if(res!=0) {
			 PrintWriter pr =resp.getWriter();
			 pr.print("<h1> Result Save With the id number "+s1.getId()+"</h1>");
		 }
	}

}
