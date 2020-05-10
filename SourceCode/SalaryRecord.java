package SourceCode;
import java.util.*;
import java.text.SimpleDateFormat; 
import java.io.*; 

public class SalaryRecord {
	private static Map<Integer, DailyHour> hourlyEmployeeWorkRecord = new HashMap<>();
	// private static Map<Integer, HourlyEmployee> hourlyEmployeeList = new HashMap<>();
	// private static Map<Integer, HourlyEmployee> hourlyEmployeeList = new HashMap<>();

	public static void postTimeCard() throws Exception {
		System.out.print("\n-- Input following Details To add to the Time Card --\n");
		
		// Get Date
		System.out.print("Input Date (Leave empty to take todays date) : ");
		String inputDateString = (new Scanner(System.in)).nextLine();
		Date inputDate;
		if(inputDateString.length()>0) inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateString);  
		else inputDate = new Date();
		
		// Get Employee ID
		System.out.print("Input Employee ID : ");
		int employeeID = (new Scanner(System.in)).nextInt();

		// Get Hours
		System.out.print("Input Number of worked Hours : ");
		double workedHours = (new Scanner(System.in)).nextDouble();

		if(!hourlyEmployeeWorkRecord.containsValue(employeeID)) hourlyEmployeeWorkRecord.put(employeeID, new DailyHour());
		
		hourlyEmployeeWorkRecord.get(employeeID).addEntry(inputDate, workedHours);
	}
}