package SourceCode;

final public class HourlyEmployee extends Employee {
	private double hourlyRate;
	private static int increaseRateAfter=8;

	public HourlyEmployee(String name, int paymentMethod, double hourlyRate) {
		super(name, paymentMethod);
		this.hourlyRate = hourlyRate;
	}

}