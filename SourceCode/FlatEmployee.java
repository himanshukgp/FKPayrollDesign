package SourceCode;

final public class FlatEmployee extends Employee {
	private double monthlySalary;

	public double getMonthlySalary(){
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary){
		this.monthlySalary=monthlySalary;
	}

	public FlatEmployee(String name, int paymentMethod, double monthlySalary) {
		super(name, paymentMethod);
		this.monthlySalary = monthlySalary;
	}

}