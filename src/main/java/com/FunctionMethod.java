package com;

import java.util.Scanner;
import org.apache.log4j.*;

public class FunctionMethod {
	
	static Logger log = Logger.getLogger(FunctionMethod.class.getName());
	
	public static void main(String[] arsg) {
		try {
			
			System.out.println("choose any one");
			System.out.println("1.create");
			System.out.println("2.modify");
			System.out.println("3.delete");
			System.out.println("4.search employee");
			System.out.println("5.json data");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			if (choice == 1) {
				CreateUser.createUser();
			} else if (choice == 2) {
				UpdateUser.updateUser();
			} else if (choice == 3) {
				DeleteUser.deleteUser();
			} else if (choice == 4) {
				SearchFunction.singleList();
			}else if(choice == 5) {
				JsonText.jsonData();
			}else {
				log.warn("please enter the following choice only");
				//System.out.println("invalid choice");
			}
			scan.close();
		} catch (Exception e) {
			log.trace(e);
			//e.printStackTrace();
		}
	}
}

class Employee {

}

class PermanentEmployee extends Employee {
	public static String empmethod() {
		//String query = "";
		return "permanent employee class";
	}
}

class PartTimeEmployee extends Employee {
	public static String empmethod() {
		return "part time employee class";
	}
}

class ContractEmployee extends Employee {
	public static String empmethod() {
		return "contract employee class";
	}
}
