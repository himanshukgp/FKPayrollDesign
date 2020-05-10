package SourceCode;

import java.util.*;
import java.io.*;

public class Driver {
	private static void mainPrompt() throws IOException{
		while(true){
			System.out.println("\n1. Add a new employee \n2. Delete an employee\n3. Post a time card\n4.Post a sales receipt\n5. Post a union membership, service charge etc.\n6. Change employee details (e.g., hourly rate, dues rate, membership fee etc)\n7. Run the payroll for today\n8.Exit program\n");
			System.out.print("\n Input option : ");
			Scanner sc=new Scanner(System.in);  
			int choice = sc.nextInt();

			switch (choice) {
				case 1:
					EmployeeList.addEmployee();
					break;
				case 8:
					System.exit(0);
				default:
					System.out.println("Invalid Request! Please choose a valid Input\n");
			}

		}

	}

	private static void loadData() throws FileNotFoundException{
		EmployeeList.loadEmployee();		
	}

	private static void setIDCount(){
		EmployeeList.setID();
	}


	public static void main(String[] args) throws Exception{
		loadData();
		setIDCount();
		
		mainPrompt();
	}
}