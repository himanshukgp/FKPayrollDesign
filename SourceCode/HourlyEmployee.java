package SourceCode;

final public class HourlyEmployee extends Employee {
	private double hourlyRate;
	private static int increaseRateAfter=8;

	public double getHourlyRate(){
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate){
		this.hourlyRate=hourlyRate;
	}

	public HourlyEmployee(String name, int paymentMethod, double hourlyRate) {
		super(name, paymentMethod);
		this.hourlyRate = hourlyRate;
	}

}