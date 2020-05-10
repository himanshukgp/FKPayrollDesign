package SourceCode;
import java.util.*;

public class SalesRecord implements WeeklyPayRoll {
	private Map<Date, Double> salesValue = new HashMap<>();

	public void addEntry(Date date, Double sales){
		// if(workedHours.get(date)) {
		// 	System.out.println("There is already a value Do you want to overrite ? (y/n) : ");
		// }
		salesValue.put(date,sales);
	}

	public double calculatePay(double rate){
		double result=0;
		for (Map.Entry<Date, Double> entry : salesValue.entrySet()) {
		    if(entry.getValue()>8){
		    	result = 8*rate + (entry.getValue()-8)*(1.5*rate);
		    }
		    else result = rate*entry.getValue();
		}
		return result;
	}
}