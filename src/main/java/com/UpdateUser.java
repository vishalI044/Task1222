package com;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class UpdateUser {
	
	static Logger log = Logger.getLogger(FunctionMethod.class.getName());
	
	public static void updateUser() {
		Scanner scan = new Scanner(System.in);
		Connection con;
		try {
			con = DBConnection.initialise();
			Statement st = con.createStatement();
			System.out.println("choice type 1.permanent | 2.partTime | 3.contract");
			int employeeType = scan.nextInt();

			if (employeeType == 1) {
				System.out.println("enter employeeID");
				int employeeID = scan.nextInt();
				
				System.out.println("enter employee name");
				String NewEmployeeName = scan.next();
				System.out.println("enter employee salary");
				String NewEmployeeSalary = scan.next();
				String QueryPer = "UPDATE Permanent_Employee SET employeeName ='" + NewEmployeeName
						+ "', employeeSalary = '" + NewEmployeeSalary + "' WHERE employeeID =" + employeeID + ";";

				st.executeUpdate(QueryPer);

			} else if (employeeType == 2) {
				System.out.println("enter employeeID");
				int employeeID = scan.nextInt();
				
				System.out.println("enter employee name");
				String NewEmployeeName = scan.next();
				System.out.println("enter employee salary");
				String NewEmployeeSalary = scan.next();
				String QueryPar = "UPDATE PartTime_Employee SET employeeName ='" + NewEmployeeName
						+ "', employeeSalary = '" + NewEmployeeSalary + "' WHERE employeeID =" + employeeID + ";";

				st.executeUpdate(QueryPar);
			} else if (employeeType == 3) {
				System.out.println("enter employeeID");
				int employeeID = scan.nextInt();

				System.out.println("enter employee name");
				String NewEmployeeName = scan.next();
				System.out.println("enter employee salary");
				String NewEmployeeSalary = scan.next();
				String QueryCon = "UPDATE Contract_Employee SET employeeName ='" + NewEmployeeName
						+ "', employeeSalary = '" + NewEmployeeSalary + "' WHERE employeeID =" + employeeID + ";";

				st.executeUpdate(QueryCon);
			} else {
				log.warn("enter the given choices only");
			}
		} catch (Exception e) {
			log.trace(e);
			//e.printStackTrace();
		}
		scan.close();
		System.out.println("user modified");
	}
}
