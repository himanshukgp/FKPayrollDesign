package SourceCode;

import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
// import com.google.gson.GsonBuilder;


public class EmployeeList {
	private static Map<Integer, HourlyEmployee> hourlyEmployeeList = new HashMap<>();
	private static Map<Integer, FlatEmployee> flatEmployeeList = new HashMap<>();

	private static void addHourlyEmployee(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Input Name: ");
		String name = sc.nextLine();
		System.out.print("Input Required payment method:\n1. Paychecks mailed to the postal address\n2. Paychecks held for pickup by the paymaster\n3. Paychecks be directly deposited into the bank account of their choice\n\tInput:");
		int paymentMethod = (new Scanner(System.in)).nextInt();
		System.out.print("Input Hourly Rate : ");
		double hourlyRate = (new Scanner(System.in)).nextDouble();
		HourlyEmployee emp = new HourlyEmployee(name, paymentMethod, hourlyRate);
		hourlyEmployeeList.put(emp.getID(), emp);
	}

	private static void addFlatEmployee(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Input Name: ");
		String name = sc.nextLine();
		System.out.print("Input Required payment method:\n1. Paychecks mailed to the postal address\n2. Paychecks held for pickup by the paymaster\n3. Paychecks be directly deposited into the bank account of their choice\n\tInput:");
		int paymentMethod = sc.nextInt();
		System.out.print("Input monthly salary : ");
		double monthlySalary = sc.nextDouble();
		FlatEmployee emp = new FlatEmployee(name, paymentMethod, monthlySalary);
		flatEmployeeList.put(emp.getID(), emp);
	}

	private static void saveToJson() throws IOException{
		
        Gson gson = new Gson();
        
        FileWriter fileWriter = new FileWriter("HourlyEmployeeData.json");
        gson.toJson(hourlyEmployeeList, fileWriter);
        fileWriter.close();

        // Files.write("", jsonHourlyEmployeeList.getBytes());
        // String jsonFlatEmployeeList = gson.toJson(flatEmployeeList);
        // Files.write("FlatEmployeeData.json", jsonFlatEmployeeList.getBytes());



        //deserialization process
        // Entity entity1 = gson.fromJson(jsonFormat, Entity.class);
        // System.out.println(entity1.name + " " + entity1.url);
	}

	public static void addEmployee() throws IOException{
		Scanner sc=new Scanner(System.in);  

		System.out.print("\n1. For Hourly Employee input 1\n2. For Flat Employee input 2\n");
		System.out.print("Input : ");
		int choice = sc.nextInt();

		if(choice==1){
			addHourlyEmployee();
			saveToJson();
		}
		else if(choice==2){
			addFlatEmployee();
			saveToJson();
		}
		else{
			System.out.println("Invalid input. Please provide a valid input!");
		}
	}
}