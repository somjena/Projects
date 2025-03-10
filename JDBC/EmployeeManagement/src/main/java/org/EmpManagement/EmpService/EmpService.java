package org.EmpManagement.EmpService;
import org.EmpManagement.EmpRepo.EmpRepository;
import org.EmpManagement.Entity.Emp;

import java.sql.*;
import java.util.Scanner;

public class EmpService implements EmpRepository {

    private static Connection con;
    private static Scanner sc = new Scanner(System.in);
    Emp e = new Emp();

    static {
        try {
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/emp?user=postgres&password=123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void registerEmp() {
        String sql ="insert into employee values(?,?,?,?)";
        System.out.print("Enter the Employee Name:");
        e.setName(sc.next());
        System.out.print("Enter the Employee Age:");
        e.setAge(sc.nextInt());
        System.out.print("Enter the Salary:");
        e.setSal(sc.nextDouble());
        e.setId(getId()+1);

        try {
       PreparedStatement pstm= con.prepareStatement(sql);
       pstm.setInt(1,e.getId());
       pstm.setString(2,e.getName());
       pstm.setInt(3,e.getAge());
       pstm.setDouble(4,e.getSal());
       int rowsaffect =pstm.executeUpdate();
       if (rowsaffect>0){
           System.out.println("✅ Employee Registered Successfully! With id No :- "+e.getId());
           sc.nextLine();
       }else{
           System.out.println(" Issue to Register Employee!\n");
       }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateEmp() {
        String sql="update employee set sal=? where id=?";
        System.out.println("Enter the id U want to Update");
        e.setId(sc.nextInt());
        System.out.println("Enter the Sal U want to Update");
        e.setSal(sc.nextDouble());
        try {
          PreparedStatement pr = con.prepareStatement(sql);
          pr.setDouble(1,e.getSal());
          pr.setInt(2,e.getId());
          int rows=pr.executeUpdate();
          if (rows>0){
              System.out.println("Update Successfully of id "+e.getId());
          }else {
              System.out.println(" Update Failed");
          }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void deleteEmp() {
        String sql= "delete from employee where id = ?";
        System.out.println("Enter the Id You Want to Remove");
        e.setId(sc.nextInt());
        try {
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1,e.getId());
       int rowsaffect =ps.executeUpdate();
       if (rowsaffect>0){
           System.out.println("SuccessFully Deleted "+e.getId());
       }else{
           System.out.println("Key Is Not Available");
       }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void empDetails() {
        String sql = "select * from employee";
        try {
          ResultSet rs =  con.createStatement().executeQuery(sql);
            if (!rs.isBeforeFirst()) { // Checks if there is at least one row
                System.out.println("\n❌ No Data Available to Show!\n");
                return;
            }

            System.out.println("=====================================================");
              System.out.printf("| %-5s | %-20s | %-5s | %-10s |\n", "ID", "Name", "Age", "Salary");
              System.out.println("=====================================================");
              while (rs.next()) {
                  int id = rs.getInt(1);
                  String name = rs.getString(2);
                  int age = rs.getInt(3);
                  double salary = rs.getDouble(4);
                  System.out.printf("| %-5d | %-20s | %-5d | %-10.2f |\n", id, name, age, salary);

              }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public int getId() {
       String Sql = "select * from employee";
       int id= 0;

        try {
          ResultSet rs= con.createStatement().executeQuery(Sql);
          while (rs.next()) {
              id = rs.getInt(1);
          }
          return id;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void exit() {

        try {

            con.close();
            Thread.sleep(500);
            System.out.println("Thanks for Using Employee Management System");
            System.out.print("Closing");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            System.out.println("Exited");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
