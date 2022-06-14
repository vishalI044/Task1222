package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner; 

import org.apache.log4j.Logger;

public class CreateUser {
	
	static Logger log = Logger.getLogger(FunctionMethod.class.getName());
	
	public static void createUser() {
		Scanner scan = new Scanner(System.in);
		Connection con;
		try {
			con = DBConnection.initialise();
			Statement st = con.createStatement();
			System.out.println("enter employeeID");
			int employeeID = scan.nextInt();

			System.out.println("employee Name:");
			String employeeName = scan.next();

			System.out.println("employee password :");
			String employeePass = scan.next();

			System.out.println("employee Salary");
			String employeeSalary = scan.next();

			System.out.println("employee type: 1. permanent | 2.parttime | 3.contract");
			int employeeDprt = scan.nextInt();

			if (employeeDprt == 1) {
				String insertQuery = "INSERT INTO Permanent_Employee VALUES(" + employeeID + ", '" + employeeName
						+ "', '" + employeePass + "', '" + employeeSalary + "', '" + employeeDprt + "')";
				st.executeUpdate(insertQuery);
			} else if (employeeDprt == 2) {
				String insertQuery = "INSERT INTO PartTime_Employee VALUES(" + employeeID + ", '" + employeeName
						+ "', '" + employeePass + "', '" + employeeSalary + "', '" + employeeDprt + "')";
				st.executeUpdate(insertQuery);
			} else if (employeeDprt == 3) {
				String insertQuery = "INSERT INTO Contract_Employee VALUES(" + employeeID + ", '" + employeeName
						+ "', '" + employeePass + "', '" + employeeSalary + "', '" + employeeDprt + "')";
				st.executeUpdate(insertQuery);
			}
			else {
				log.warn("enter only given choices");
			}
			System.out.println("user created");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			log.trace(e);
			//e.printStackTrace();
		}
		scan.close();
		
	}
}
