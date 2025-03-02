package org.EmpManagement.EmpDriver;
import org.EmpManagement.EmpRepo.EmpRepository;
import org.EmpManagement.EmpService.EmpService;

import java.util.Scanner;

public class EmployeeDriver {
    public static void main(String[] args) {
        System.out.println("     "+"===========================================");
        System.out.println("               Welcome to Employee Management      ");
        System.out.println("     "+"===========================================");
        EmpRepository emp = new EmpService();
        Scanner sc = new Scanner(System.in);
        System.out.println("====================Enter Choice=======================");
        while(true){
            System.out.println("1.Add Employee \n2.Update Details\n3.Delete Employee \n4.Fetch Employee\n5.Exit");
            int choice=sc.nextInt();
            switch (choice){
                case 1:emp.registerEmp();
                break;
                case 2:emp.updateEmp();
                break;
                case 3:emp.deleteEmp();
                break;
                case 4:emp.empDetails();
                break;
                case 5:emp.exit();
                return;
                default:
                    System.out.println("Enter the Wrong input");

            }
        }
    }
}
