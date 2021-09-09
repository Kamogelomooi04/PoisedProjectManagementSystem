
public class Engineer {

	// Attributes:
	private String engineerName;
	private int engineerNumber;
	private String engineerEmail;
	private String engineerAddress;
	
	// Constructor:
	public Engineer(String engineerName, int engineerNumber, String engineerEmail, String engineerAddress ) {
		this.engineerName = engineerName;
		this.engineerNumber = engineerNumber;
		this.engineerEmail = engineerEmail;
		this.engineerAddress = engineerAddress;
		
	}
	
	// Methods, getters:
	public String getEngineerName() {
		return engineerName;	
	}
	
	public int getEngineerNumber() {
		return engineerNumber;
	}
	
	public String getEngineerEmail() {
		return engineerEmail;
	}
	
	public String getEngineerAddress() {
		return engineerAddress;
	}
	
	// Methods, setters:
	public void setContractorName(String engineerName) {
		this.engineerName = engineerName;
	}
	
	public void setEngineerNumber(int engineerNumber) {
		this.engineerNumber = engineerNumber;
	}
	
	public void setEngineerEmail(String engineerEmail) {
		this.engineerEmail = engineerEmail ;
	}
	
	public void setEngineerAddress(String engineerAddress) {
		this.engineerAddress = engineerAddress;
	}
	
	//toString method:
	public String toString() {
		String output = "(null, '" + engineerName + "', " + engineerNumber + ", " + "'" + engineerEmail + "'" + ", '" + engineerAddress + "')";
		
		return output;
	}
}
