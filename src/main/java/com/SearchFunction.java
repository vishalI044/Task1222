package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class SearchFunction {
	
	static Logger log = Logger.getLogger(FunctionMethod.class.getName());
	
	public static void singleList() {
		Scanner scan = new Scanner(System.in);
		Connection con;
		try {
			
			Hashtable ht = new Hashtable();
			con = DBConnection.initialise();
			Statement st = con.createStatement();
			ResultSet result;
			System.out.println("1.permanent | 2.partTime | 3.contract");
			int employeeType = scan.nextInt();
			if(employeeType == 1) {
				System.out.println("enter employee ID");
				int employeeID = scan.nextInt();
				
				String query = "SELECT * FROM employee_database.permanent_employee WHERE employeeID = '"+employeeID+"';";
				result = st.executeQuery(query);
				
				if(result.next()) {
					ht.put("employeeDprt", result.getInt("employeeDprt"));
					ht.put("employeeName", result.getString("employeeName"));
					ht.put("emloyeeSalary", result.getInt("employeeSalary"));
					System.out.println(ht);
				}
			}else if(employeeType == 2) {
				System.out.println("enter employee ID");
				int employeeID = scan.nextInt();
				String query = "SELECT * FROM employee_database.parttime_employee WHERE employeeID = '"+employeeID+"';";
				result = st.executeQuery(query);
				if(result.next()) {
					ht.put("employeeDprt", result.getInt("employeeDprt"));
					ht.put("employeeName", result.getString("employeeName"));
					ht.put("emloyeeSalary", result.getInt("employeeSalary"));
					System.out.println(ht);
				}
			}else if(employeeType == 3) {
				System.out.println("enter employee ID");
				int employeeID = scan.nextInt();
				String query = "SELECT * FROM employee_database.contract_employee WHERE employeeID = '"+employeeID+"';";
				result = st.executeQuery(query);
				if(result.next()) {
					ht.put("employeeDprt", result.getInt("employeeDprt"));
					ht.put("employeeName", result.getString("employeeName"));
					ht.put("emloyeeSalary", result.getInt("employeeSalary"));
					System.out.println(ht);
				}
			}else {
				log.warn("Enter correct choice");
			}
			ht.clear();
		}catch(Exception e) {
			log.trace(e);
		}
		scan.close();
	}
}
