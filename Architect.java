
public class Architect {
	
	// Attributes:
	private String architectName;
	private int architectNumber;
	private String architectEmail;
	private String architectAddress;
	
	// Constructor:
	public Architect(String architectName, int architectNumber, String architectEmail, String architectAddress ) {
		this.architectName = architectName;
		this.architectNumber = architectNumber;
		this.architectEmail = architectEmail;
		this.architectAddress = architectAddress;
		
	}
	
	// Methods, getters:
	public String getArchitectName() {
		return architectName;	
	}
	
	public int getArchitectNumber() {
		return architectNumber;
	}
	
	public String getArchitectEmail() {
		return architectEmail;
	}
	
	public String ArchitectAddress() {
		return architectAddress;
	}
	
	// Methods, setters:
	public void setArchitectName(String architectName) {
		this.architectName = architectName;
	}
	
	public void setArchitectNumber(int architectNumber) {
		this.architectNumber = architectNumber;
	}
	
	public void setArchitectEmail(String architectEmail) {
		this.architectEmail = architectEmail ;
	}
	
	public void setArchitectAddress(String architectAddress) {
		this.architectAddress = architectAddress;
	}
	
	//toString method:
	public String toString() {
		String output = "(null, '" + architectName + "', " + architectNumber + ", " + "'" + architectEmail + "'" + ", '" + architectAddress + "')";
		
		return output;
	}
	
}
