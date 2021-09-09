
public class Customer {
	
	// Attributes:
	private String customerName;
	private int customerNumber;
	private String customerEmail;
	private String customerAddress;
	
	// Constructor:
	public Customer(String customerName, int customerNumber, String customerEmail, String customerAddress ) {
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		
	}
	
	// Methods, getters:
	public String getCustomerName() {
		return customerName;	
	}
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public String getCustomerAddress() {
		return customerAddress;
	}
	
	// Methods, setters:
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail ;
	}
	
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	//toString method:
	public String toString() {
		String output = "(null, '" + customerName + "', " + customerNumber + ", " + "'" + customerEmail + "'" + ", '" + customerAddress + "')";
		
		return output;
	}
}
