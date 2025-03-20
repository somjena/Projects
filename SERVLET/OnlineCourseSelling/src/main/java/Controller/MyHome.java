package Controller;

import Entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/home")
public class MyHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       int id=Integer.parseInt(req.getParameter("id")) ;
       String name = req.getParameter("name");
        System.out.println(id +" "+ name);
        User u1 = new User(id,name);
        ServletContext context=getServletContext();
        context.setAttribute("User",u1);

    }
}
