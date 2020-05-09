package SourceCode;

public class Employee {
	private static int count = 1100;
	private int ID;
	private String name;
	private int paymentMethod;
	private double salesCommission=0;
	private double unionMembershipCharge=0;


	// Getters
	final public int get_ID() {
		return ID;
	}
	final public String get_name() {
		return name;
	}
	final public int get_paymentMethod() {
		return paymentMethod;
	}
	final public double get_salesCommission() {
		return salesCommission;
	}
	final public double get_unionMembershipCharge() {
		return unionMembershipCharge;
	}

	// Setters
	final public void set_paymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	final public void set_paymentMethod(double salesCommission) {
		this.salesCommission = salesCommission;
	}
	final public void set_paymentMethod(double unionMembershipCharge) {
		this.unionMembershipCharge = unionMembershipCharge;
	}




	public Employee(String name, int paymentMethod){
		ID = count++;
		this.name = name;
		this.paymentMethod = paymentMethod;
	}

	public static void main(String[] args){
		Employee a = new Employee("himanshu", 1);
		System.out.println(a.get_ID());
	}

}