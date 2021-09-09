
public class Contractor {

	// Attributes:
	private String contractorName;
	private int contractorNumber;
	private String contractorEmail;
	private String contractorAddress;
	
	// Constructor:
	public Contractor(String contractorName, int contractorNumber, String contractorEmail, String contractorAddress ) {
		this.contractorName = contractorName;
		this.contractorNumber = contractorNumber;
		this.contractorEmail = contractorEmail;
		this.contractorAddress = contractorAddress;
		
	}
	
	// Methods, getters:
	public String getContractorName() {
		return contractorName;	
	}
	
	public int getContractorNumber() {
		return contractorNumber;
	}
	
	public String getContractorEmail() {
		return contractorEmail;
	}
	
	public String getContractorAddress() {
		return contractorAddress;
	}
	
	// Methods, setters:
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	
	public void setContractorNumber(int contractorNumber) {
		this.contractorNumber = contractorNumber;
	}
	
	public void setContractorEmail(String contractorEmail) {
		this.contractorEmail = contractorEmail ;
	}
	
	public void setContractorAddress(String contractorAddress) {
		this.contractorAddress = contractorAddress;
	}
	
	//toString method:
	public String toString() {
		String output = "(null, '" + contractorName + "', " + contractorNumber + ", " + "'" + contractorEmail + "'" + ", '" + contractorAddress + "')";
		
		return output;
	}
}
