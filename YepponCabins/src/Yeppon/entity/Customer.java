package Yeppon.entity;

public class Customer {
	
	private String customerName;
	private int numberofNights;
	
	public Customer(String customerName, int numberofNights) {
		super();
		this.customerName = customerName;
		this.numberofNights = numberofNights;
	}

	public Customer() {
		super();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNumberofNights() {
		return numberofNights;
	}

	public void setNumberofNights(int numberofNights) {
		this.numberofNights = numberofNights;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", numberofNights=" + numberofNights + "]";
	}
	
}
