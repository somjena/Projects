	package ecourse.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Register extends HttpServlet {
	private static final String QUERY = "INSERT INTO customer values(?,?,?,?)";

    private static final String URL = "jdbc:postgresql://localhost:5432/Ecourse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String ageStr = req.getParameter("age");
        String password = req.getParameter("password");

        
        PrintWriter out = resp.getWriter();

        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pr = con.prepareStatement(QUERY)) {

                // Set parameters
                pr.setString(1, name);
                pr.setString(2, email);
                pr.setInt(3, Integer.parseInt(ageStr));
                pr.setString(4, password);

                // Execute query
                int res = pr.executeUpdate();

                if (res > 0) {
                    out.print("Hey " + name + ", you are Registered successfully!");
                } else {
                    out.print("Registration failed!");
                }
            }

        } catch (ClassNotFoundException e) {
            out.print("Database Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            out.print("Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            out.print("Invalid age format.");
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
