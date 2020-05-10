package SourceCode;
import java.util.*;

public class DailyHour implements WeeklyPayRoll {
	private Map<Date, Double> workedHours = new HashMap<>();

	public void addEntry(Date date, Double hours){
		// if(workedHours.get(date)) {
		// 	System.out.println("There is already a value Do you want to overrite ? (y/n) : ");
		// }
		workedHours.put(date,hours);
	}

	public double calculatePay(double rate){
		double result=0;
		for (Map.Entry<Date, Double> entry : workedHours.entrySet()) {
		    if(entry.getValue()>8){
		    	result = 8*rate + (entry.getValue()-8)*(1.5*rate);
		    }
		    else result = rate*entry.getValue();
		}
		return result;
	}
}