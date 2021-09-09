
public class Manager {

	// Attributes:
	private String managerName;
	private int managerNumber;
	private String managerEmail;
	private String managerAddress;
	
	// Constructor:
	public Manager(String managerName, int managerNumber, String managerEmail, String managerAddress ) {
		
		this.managerName = managerName;
		this.managerNumber = managerNumber;
		this.managerEmail = managerEmail;
		this.managerAddress = managerAddress;
		
	}
	
	// Methods, getters:
	public String getManagerName() {
		
		return managerName;	
	}
	
	public int getManagerNumber() {
		return managerNumber;
	}
	
	public String getManagerEmail() {
		return managerEmail;
	}
	
	public String getMangerAddress() {
		return managerAddress;
	}
	
	// Methods, setters:
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}
	
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail ;
	}
	
	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}
	
	//toString method:
	public String toString() {
		String output = "(null, '" + managerName + "', " + managerNumber + ", " + "'" + managerEmail + "'" + ", '" + managerAddress + "')";
		
		return output;
	}
}
