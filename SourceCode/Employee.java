package SourceCode;

public class Employee {
	private static int count = 1100;
	int ID;
	String name;
	int paymentMethod;

	public Employee(String name, int paymentMethod){
		ID = count++;
		this.name = name;
		this.paymentMethod = paymentMethod;
	}

	public int get_ID() {
		return ID;
	}

	public static void main(String[] args){
		Employee a = new Employee("himanshu", 1);
		System.out.println(a.get_ID());
	}

}