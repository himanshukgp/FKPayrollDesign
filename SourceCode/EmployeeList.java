package SourceCode;

import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
// import com.google.gson.GsonBuilder;


public class EmployeeList {
	private static Map<Integer, HourlyEmployee> hourlyEmployeeList = new HashMap<>();
	private static Map<Integer, FlatEmployee> flatEmployeeList = new HashMap<>();

	// Check for wrong query
	public static double getHourlySalary(int employeeID) {
		return hourlyEmployeeList.get(employeeID).getHourlyRate();
	}

	// Check for wrong Queries
	public static double getFlatSalary(int employeeID){
		return flatEmployeeList.get(employeeID).getMonthlySalary();
	}

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

        FileWriter fileWriter1 = new FileWriter("FlatEmployeeData.json");
        gson.toJson(flatEmployeeList, fileWriter1);
        fileWriter1.close();

        // Files.write("", jsonHourlyEmployeeList.getBytes());
        // String jsonFlatEmployeeList = gson.toJson(flatEmployeeList);
        // Files.write("FlatEmployeeData.json", jsonFlatEmployeeList.getBytes());



        //deserialization process
        // Entity entity1 = gson.fromJson(jsonFormat, Entity.class);
        // System.out.println(entity1.name + " " + entity1.url);
	}

	public static void loadEmployee() throws FileNotFoundException {
		Type type1 = new TypeToken<Map<Integer, HourlyEmployee>>(){}.getType();
		Gson gson = new Gson();
		FileReader temp_file_hourly = new FileReader("HourlyEmployeeData.json");
		JsonReader reader1 = new JsonReader(temp_file_hourly);
		hourlyEmployeeList = gson.fromJson(reader1, type1);

		Type type2 = new TypeToken<Map<Integer, FlatEmployee>>(){}.getType();
		FileReader temp_file_flat = new FileReader("FlatEmployeeData.json");
		JsonReader reader2 = new JsonReader(temp_file_flat);
		flatEmployeeList = gson.fromJson(reader2, type2);
	}

	public static void setID(){
		int ID = 1100;
		for (Map.Entry<Integer, HourlyEmployee> entry : hourlyEmployeeList.entrySet()) {
		    if(ID<=entry.getKey()) ID = entry.getKey()+1;
		}
		for (Map.Entry<Integer, FlatEmployee> entry : flatEmployeeList.entrySet()) {
			if(ID<=entry.getKey()) ID = entry.getKey()+1;
		}
		Employee.setCount(ID);
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

	public static void deleteEmployee() throws IOException{
		System.out.print("Input Employee ID to Delete : ");
		int empIDToDelete = (new Scanner(System.in)).nextInt();

		if(!hourlyEmployeeList.containsKey(empIDToDelete) && !flatEmployeeList.containsKey(empIDToDelete)) {
			System.out.println("Employee ID does not exist!\nPlease check ID and Try again.");
		}
		else{
			if(hourlyEmployeeList.containsKey(empIDToDelete)){
				hourlyEmployeeList.remove(empIDToDelete);
			}
			else{
				flatEmployeeList.remove(empIDToDelete);
			}
			saveToJson();
		}
	}
}