package SourceCode;

public class Employee {
	private static int count = 1100;
	private int ID;
	private String name;
	private int paymentMethod;
	private double salesCommission=0;
	private double unionMembershipCharge=0;

	public static void setCount(int ID){
		count = ID;
	}


	// Getters
	final public int getID() {
		return ID;
	}
	final public String getName() {
		return name;
	}
	final public int getPaymentMethod() {
		return paymentMethod;
	}
	final public double getSalesCommission() {
		return salesCommission;
	}
	final public double getUnionMembershipCharge() {
		return unionMembershipCharge;
	}

	// Setters
	final public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	final public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}
	final public void setUnionMembershipCharge(double unionMembershipCharge) {
		this.unionMembershipCharge = unionMembershipCharge;
	}




	public Employee(String name, int paymentMethod){
		ID = count++;
		this.name = name;
		this.paymentMethod = paymentMethod;
	}

}