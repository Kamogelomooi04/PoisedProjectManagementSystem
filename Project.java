
public class Project {

	//Attributes 
	private String projectName;
	private String buildingType;
	private String projectAddress;
	private int EFRNumber;
	private int totalFeeCharged;
	private int totalPaidToDate;
	private String projectDeadline;
	private String status;
	private String completionDate;
	
	
	
	//Constructor.
	public Project(String projectName, String buildingType, String projectAddress,
			int EFRNumber, int totalFeeCharged, int totalPaidToDate, String projectDeadline, String status, String completionDate) {
		
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.projectAddress = projectAddress;
		this.EFRNumber = EFRNumber;
		this.totalFeeCharged = totalFeeCharged;
		this.totalPaidToDate = totalPaidToDate;
		this.projectDeadline = projectDeadline;
		this.status = status;
		this.completionDate = completionDate;
	}
	
	//Methods:
	public String getProjectName() {
		return projectName;
	}
	/*
	 * If project does not have a name then the project will be  named by the building 
 	   followed by the custoer's last name.
	 */
	public void setProjectName(String projectName, String customerLastName) {
		if(projectName == null) {
			this.projectName = buildingType + " " + customerLastName;
		}
	}
	
	public String getBuildingType() {
		return buildingType;
	}
	
	public String getProjectAddress() {
		return projectAddress;
	}
	
	public int getERFNumber() {
		return EFRNumber;
	}
	
	public int getTotalFeeCharged() {
		return totalFeeCharged;
	}
	
	public int getTotalPaidToDate() {
		return totalPaidToDate;
	}
	
	public String getProjectDeadline() {
		return projectDeadline;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getCompletionDate() {
		return completionDate;
	}
	
	//toString method:
	public String toString() {
		 String output = "(null, '" + projectName + "', '" + buildingType + "', '" + projectAddress + "', " 
				 + EFRNumber + ", '" + projectDeadline + "' ," + totalFeeCharged + ", " + totalPaidToDate + ", '" 
				 + status + "', '" + completionDate + "')";
		 return output;
	}
	
}
