package Controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/enter")
public class inputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       String sem1= req.getParameter("firstsem");
        String sem2= req.getParameter("secondsem");
        String sem3= req.getParameter("thirdsem");
        String sem4= req.getParameter("fourthsem");
        System.out.println(sem1 +" "+ sem2 +" "+sem3 +" "+sem4);
        int s1gp =Integer.parseInt(sem1)/10;
        int s2gp =Integer.parseInt(sem2)/10;
        int s3gp =Integer.parseInt(sem3)/10;
        int s4gp =Integer.parseInt(sem4)/10;
        float f= s1gp+s2gp+s3gp+s4gp;
        float cgpa = f/4;
        resp.getWriter().print("<html><body><h1> Your Total  CGPA :-"+cgpa+"</body></h1></html>");

    }
}
