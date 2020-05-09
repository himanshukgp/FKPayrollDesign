package SourceCode;

final public class HourlyEmployee extends Employee {
	private double hourlyRate;
	private static int increaseRateAfter=8;

	public HourlyEmployee(String name, int paymentMethod, double hourlyRate) {
		super(name, paymentMethod);
		this.hourlyRate = hourlyRate;
	}

	public static void main(String[] args){
		HourlyEmployee a = new HourlyEmployee("himanshu", 1, 5000);
		System.out.println(a.get_ID());
	}

}