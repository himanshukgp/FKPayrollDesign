package SourceCode;
import java.util.*;
import java.text.SimpleDateFormat; 
import java.io.*; 

public class SalaryRecord {
	private static Map<Integer, DailyHour> hourlyEmployeeWorkRecord = new HashMap<>();
	private static Map<Integer, SalesRecord> employeeSalesRecord = new HashMap<>();
	// private static Map<Integer, HourlyEmployee> hourlyEmployeeList = new HashMap<>();


	public static void postSalesCard() throws Exception {
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

		// If rate is 0 set rate
		if(EmployeeList.getSalesRate(employeeID)==0){
			System.out.print("Sales Rate not set yet, Enter Sales Rate in % : ");
			double salesRate = (new Scanner(System.in)).nextDouble();
			EmployeeList.setSalesRate(employeeID, salesRate);
		}


		// Get sales
		System.out.print("Input Amount of sales : ");
		double sales = (new Scanner(System.in)).nextDouble();

		if(!employeeSalesRecord.containsKey(employeeID)) employeeSalesRecord.put(employeeID, new SalesRecord());

		employeeSalesRecord.get(employeeID).addEntry(inputDate, sales);		

	}

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


	public static Map<Integer, Double> calculateHourlySalary() {
		Map<Integer, Double> resultSalary = new HashMap<>();
		for (Map.Entry<Integer, DailyHour> entry : hourlyEmployeeWorkRecord.entrySet()) {
			int key = entry.getKey();
			double rate = EmployeeList.getHourlySalary(key);

		    resultSalary.put(key, entry.getValue().calculatePay(rate));
		}
		return resultSalary;
	}

	public static Map<Integer, Double> calculateSalesSalary() {
		Map<Integer, Double> resultSalary = new HashMap<>();
		for (Map.Entry<Integer, SalesRecord> entry : employeeSalesRecord.entrySet()) {
			int employeeID = entry.getKey();
			double rate = EmployeeList.getSalesRate(employeeID);

		    resultSalary.put(employeeID, entry.getValue().calculatePay(rate));
		}
		return resultSalary;
	}	

	public static void calculateSalary() {
		Map<Integer, Double> resultSalaryHourly = calculateHourlySalary();
		Map<Integer, Double> resultSalarySales = calculateSalesSalary();

		for (Map.Entry<Integer, Double> entry : resultSalaryHourly.entrySet()) {
		    System.out.println("Employee Id : " + entry.getKey() + " gets Rs " + entry.getValue() + " for Hourly working");
		}

		for (Map.Entry<Integer, Double> entry : resultSalarySales.entrySet()) {
		    System.out.println("Employee Id : " + entry.getKey() + " gets Rs " + entry.getValue() + " for Sales");
		}

	}
}