package Controller;

import Entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=getServletContext();
        User user=(User)context.getAttribute("User");
        PrintWriter pr=resp.getWriter();
        if (user!=null){
            System.out.println("Your id is "+user.id);
            System.out.println("Your name is "+user.name);


        }
    }
}
