package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection initialise () throws SQLException, ClassNotFoundException {
		
		String dbdriver="com.mysql.jdbc.Driver";
		String dburl="jdbc:mysql://localhost:3306/Employee_database";
		String dbusername="root";
		String dbpassword="Vishal@123";
		Class.forName(dbdriver);
		Connection conn = DriverManager.getConnection(dburl, dbusername, dbpassword); 
		
		return conn;
	}
}
