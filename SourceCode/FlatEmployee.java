package SourceCode;

final public class FlatEmployee extends Employee {
	private double monthlySalary;

	public FlatEmployee(String name, int paymentMethod, double monthlySalary) {
		super(name, paymentMethod);
		this.monthlySalary = monthlySalary;
	}

}