package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonText {
	static Logger log = Logger.getLogger(FunctionMethod.class.getName());
	
	public static void jsonData() {
		Scanner scan = new Scanner(System.in);
		Connection con;
		try {
			con = DBConnection.initialise();
			Statement st = con.createStatement();
			ResultSet result;
			Hashtable empHashmap = new Hashtable();
			
			System.out.println("employee type: 1. permanent | 2.parttime | 3.contract");
			int employeeType = scan.nextInt();
			if(employeeType == 1) {
				String query = "SELECT * FROM permanent_employee;";
				result = st.executeQuery(query);
				while(result.next()) {
					empHashmap.put("employeeID", result.getObject("employeeID"));
					empHashmap.put("employeeName", result.getObject("employeeName"));
					empHashmap.put("employeePass", result.getObject("employeePass"));
					empHashmap.put("employeeSalary", result.getObject("employeeSalary"));
					empHashmap.put("employeeDprt", result.getObject("employeeDprt"));
					
					Gson gson = new GsonBuilder().disableHtmlEscaping().create();
					String jsonText = gson.toJson(empHashmap);
					System.out.println(jsonText);
				}
			}else if(employeeType == 2) {
				String query = "SELECT * FROM parttime_employee;";
				result = st.executeQuery(query);
				while(result.next()) {
					empHashmap.put("employeeID", result.getObject("employeeID"));
					empHashmap.put("employeeName", result.getObject("employeeName"));
					empHashmap.put("employeePass", result.getObject("employeePass"));
					empHashmap.put("employeeSalary", result.getObject("employeeSalary"));
					empHashmap.put("employeeDprt", result.getObject("employeeDprt"));
					
					Gson gson = new GsonBuilder().disableHtmlEscaping().create();
					String jsonText = gson.toJson(empHashmap);
					System.out.println(jsonText);
				}
			}else if(employeeType == 3) {
				String query = "SELECT * FROM contract_employee;";
				result = st.executeQuery(query);
				while(result.next()) {
					empHashmap.put("employeeID", result.getObject("employeeID"));
					empHashmap.put("employeeName", result.getObject("employeeName"));
					empHashmap.put("employeePass", result.getObject("employeePass"));
					empHashmap.put("employeeSalary", result.getObject("employeeSalary"));
					empHashmap.put("employeeDprt", result.getObject("employeeDprt"));
					
					Gson gson = new GsonBuilder().disableHtmlEscaping().create();
					String jsonText = gson.toJson(empHashmap);
					System.out.println(jsonText);
				}
			}else {
				log.warn("Enter correct choice");
			}
			scan.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.warn(e);
		}
	}
}
