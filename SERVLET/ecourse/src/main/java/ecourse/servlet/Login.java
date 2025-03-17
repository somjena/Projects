package ecourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final String QUERY = "SELECT * from customer where email =? and password=?";
    private static final String URL = "jdbc:postgresql://localhost:5432/Ecourse";
    private static final String user = "postgres";
    private static final String dbpassword ="123";
   Connection con;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password"); 
        PrintWriter ptr = resp.getWriter();

       
        try {
        	Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(URL,user,dbpassword);
			PreparedStatement pr= con.prepareStatement(QUERY);
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet rs= pr.executeQuery();
			if(rs.next()) {
			}
			if(rs.getString(2).equals(email)&rs.getString(4).equals(password)) {
				
				ptr.print("<html><body>");
				ptr.print("<h4>Login Successful "+rs.getString(1)+"</h4>");
				ptr.print("<table border='1'>");
				ptr.print("<tr><th>Name</th><th>Email</th><th>age</th><th>password</th></tr>");
				ptr.print("<tr>");
				ptr.print("<td>" + rs.getString(1) + "</td>");
				ptr.print("<td>" + rs.getString(2) + "</td>");
				ptr.print("<td>" + rs.getInt(3) + "</td>");
				ptr.print("<td>" + rs.getString(4) + "</td>");
				ptr.print("</tr>");
				ptr.print("</table>");
				ptr.print("</body></html>");

			}else {
				System.out.println("Wrong Id Password");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}