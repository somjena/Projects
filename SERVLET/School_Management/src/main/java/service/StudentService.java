package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Student;

public class StudentService {
	static String url = "jdbc:mysql://localhost:3306/school?user=root&password=root";
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int register(Student s) {
		String sql = "insert into student values(?,?,?,?)";
		int res=0;
		try {
			PreparedStatement pr =con.prepareStatement(sql);
			pr.setInt(1, s.getId());
			pr.setString(2, s.getName());
			pr.setInt(3, s.getAge());
			pr.setString(4, s.getGender());
			 res =pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
		
	}

}
