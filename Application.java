import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {

	/**
	 * project management program used to store projects for engineering company.
	 * certain elements of the stored projects can me chopped and changed as the user wishes.
	 * @author K.Mooi
	 * @throws ParseException
	 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
        /**
         * try, catch block to handle any errors thrown.
         * in this case not being able to establish a connection to the database.
         */
		try {
            // Connecting to the PoisePMS database, via the jdbc:mysql: channel on localhost (this PC).
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PoisePMS?useSSL=false",
                    "root",
                    "Kamogelo_32"
                    );
			
            // Created a direct line to the database for running our queries.
            Statement statement = connection.createStatement();
            ResultSet results;
            @SuppressWarnings("unused")
			int rowsAffected;
            
            /**
             * Calling the methods that will create the different tables
             * in our data base.
             */
            rowsAffected = statement.executeUpdate(createTable_P);
            
            rowsAffected = statement.executeUpdate(createTable_C);
            
            rowsAffected = statement.executeUpdate(createTable_A);
            
            rowsAffected = statement.executeUpdate(createTable_M);
            
            rowsAffected = statement.executeUpdate(createTable_Con);
            
            rowsAffected = statement.executeUpdate(createTable_E);
            
            //set up is complete, we can now start with the project management system.
            //Here we are greeting the user and letting them know how they system works.
            //Then we'll display an option for the user.
            
            Scanner scan = new Scanner(System.in);
            
            int mainMenuChoice;
            
            System.out.println("POISED ENGINEERING PROJECT MANAGEMENT SYSTEM");

            System.out.println("\nWelcome! This system will help keep track of the many projects that"
            		+ "\nthe company works on. It will allow you, the user to capture, update and delete"
            		+ "\nprojects and project information as you like."
            		+ "\n\nTo get started simply enter the number that represents the function you'd like"
            		+ " to perform.");
            
            do {
            	System.out.println("\n1. Add a Project."
            			+ "\n2. Update information on existing projects."
            			+ "\n3. Finalise a project."
            			+ "\n4. See list of projects still to be completed."
            			+ "\n5. See list of overdue projects."
            			+ "\n6. Search for project."
            			+ "\n0. Exit.");
            	mainMenuChoice = scan.nextInt();
            	
            	/**
            	 * Switch case statements below, take care of each function from the options menu.
            	 */
            	switch(mainMenuChoice) {
            	
            	/**
            	 * If the user selects option 1(add a project).
            	 * User will be prompted for input.
            	 */
            		case 1:
            		scan.nextLine();
            		
            		System.out.println("\nEnter the project name:");
            		String projectName = readString();
            		
            		System.out.println("\nEnter the building type, E.g. House, Apartment Block or Store, etc:");
            		String buildingType = readString();
            		
            		System.out.println("\nEnter the address of the project:");
            		String projectAddress = readString();
            		
            		System.out.println("\nEnter the EFR number for this project:");
            		int EFRNumber = scan.nextInt();
            		
            		System.out.println("\nEnter the project deadline(in the format DD-MM-YYYY):");
            		String projectDeadline = readString();
            		
            		System.out.println("\nEnter the total fee charged for this project:");
            		int totalFeeCharged = scan.nextInt();
            		
            		System.out.println("\nEnter the total amount paid to date:");
            		int totalPaidToDate= scan.nextInt();
            		
            		String status = "Incomplete";
            		
            		String completionDate = "tbc";
            		
            		//Insert the information captured above into the Projects table in our 'PoisedPMS' database.
            		//First we create our project object.           		
            		Project project = new Project(projectName, buildingType, projectAddress, EFRNumber, totalFeeCharged, totalPaidToDate, projectDeadline, status, completionDate);
            		
            		//Now were communicating with MySQL.
                    rowsAffected = statement.executeUpdate(
                            "INSERT INTO Projects VALUES " + project.toString()
                        );
            		
            		System.out.println("\nProject information has been successfully captured."
            				+ "\nNow let's get some information about the customer.");
            		
            		//Now we're capturing customer details.
            		System.out.println("\nEnter the customer's full name and surname:");
            		String customerName = readString();
            		
            		System.out.println("\nEnter the customer's telephone number:");
            		int customerNumber = scan.nextInt();
            		
            		System.out.println("\nEnter the customer's Email address:");
            		String customerEmail = readString();;
            		
            		System.out.println("\nEnter the customer's physical address:");
            		String customerAddress = readString();
            		
            		//Insert the information captured above into the Customers table in our 'PoisedPMS' database.
            		//First we create our project object.
            		Customer customer = new Customer(customerName, customerNumber, customerEmail, customerAddress);
            		
            		//Now were communicating with MySQL.
                    rowsAffected = statement.executeUpdate(
                            "INSERT INTO Customers VALUES " + customer.toString()
                        );
                    
            		System.out.println("\nCustomer's information has been successfully captured."
            				+ "\nNow let's get some information about the Architect.");
            		
            		//Now were capturing the architect's details.
            		System.out.println("\nEnter the full name and surname of the architect assigned to this project:");
            		String architectName = readString();
            		
            		System.out.println("\nEnter the architect's telephone number:");
            		int architectNumber = scan.nextInt();
            		
            		scan.nextLine();
            		
            		System.out.println("\nEnter the architect's Email:");
            		String architectEmail = readString();
            		
            		System.out.println("\nEnter the architect's physical address:");
            		String architectAddress = readString();
            		
            		//Insert the information captured above into the Architects table in our 'PoisedPMS' database.
            		//First we create our project object.
            		Architect architect = new Architect(architectName, architectNumber, architectEmail, architectAddress);
            		
            		//Now were communicating with MySQL.
                    rowsAffected = statement.executeUpdate(
                            "INSERT INTO Architects VALUES " + architect.toString()
                        );
                    
            		System.out.println("\nArchitect's information has been successfully captured."
            				+ "\nNow let's get some information about the Contractor.");
            		
            		//Now were capturing the contractor's details.
            		System.out.println("\nEnter the full name and surname of the contractor assigned to this project:");
            		String contractorName = readString();

            		System.out.println("\nEnter the contractor's telephone number:");
            		int contractorNumber = scan.nextInt();

            		System.out.println("\nEnter the contractor's Email:");
            		String contractorEmail = readString();
            		
            		System.out.println("\nEnter the contractor's physical address:");
            		String contractorAddress = readString();
            		
            		//Insert the information captured above into the Contractors table in our 'PoisedPMS' database.
            		//First we create our project object.
            		Contractor contractor = new Contractor(contractorName, contractorNumber, contractorEmail, contractorAddress);
            		
            		//Now were communicating with MySQL.
                    rowsAffected = statement.executeUpdate(
                            "INSERT INTO Contractors VALUES " + contractor.toString()
                        );
                    
            		System.out.println("\nContractor's information has been successfully captured."
            				+ "\nNow let's get some information about the structural engineer.");
            		
            		//Now were capturing the engineer's details.
            		System.out.println("\nEnter the full name and surname of the engineer assigned to this project:");
            		String engineerName = readString();

            		System.out.println("\nEnter the engineer's telephone number:");
            		int engineerNumber = scan.nextInt();

            		System.out.println("\nEnter the engineer's Email:");
            		String engineerEmail = readString();

            		System.out.println("\nEnter the engineer's physical address:");
            		String engineerAddress = readString();
            		
            		//Insert the information captured above into the Engineers table in our 'PoisedPMS' database.
            		//First we create our project object.
            		Engineer engineer = new Engineer(engineerName, engineerNumber, engineerEmail, engineerAddress);
            		
            		//Now were communicating with MySQL.
                    rowsAffected = statement.executeUpdate(
                            "INSERT INTO Engineers VALUES " + engineer.toString()
                        );
                    
            		System.out.println("\n Engineer's information has been successfully captured."
            				+ "\nNow  lastly, let's get some information about the project manager.");
            		
            		//Now were capturing the project manager's details.
            		System.out.println("\nEnter the full name and surname of the project manager assigned to this project:");
            		String managerName = readString();

            		System.out.println("\nEnter the manager's telephone number:");
            		int managerNumber = scan.nextInt();

            		System.out.println("\nEnter the manager's Email:");
            		String managerEmail = readString();

            		System.out.println("\nEnter the manager's physical address:");
            		String managerAddress = scan.next();
            		
            		//Insert the information captured above into the Engineers table in our 'PoisedPMS' database.
            		//First we create our project object.
            		Manager manager = new Manager(managerName, managerNumber, managerEmail, managerAddress);
            		
            		//Now were communicating with MySQL.
                    rowsAffected = statement.executeUpdate(
                            "INSERT INTO Managers VALUES " + manager.toString()
                        );
            		break;
            		
            		/**
            		 * If the user selects option 2(to update).
            		 * User will be prompted on what they'd like to update.
            		 * further switch case statements will handle the functions of updating a project.
            		 */
            		case 2:
            			int updateChoice;
            			
            			do {
                        	System.out.println("\n1. Update project deadline."
                        			+ "\n2. Update the total amount paid to date."
                        			+ "\n0. Exit.");
                        	updateChoice = scan.nextInt();
                        	
                        	switch(updateChoice) {
                        		
                        	case 1:
                        		System.out.println("\nPlease enter the project number of the project that you'd like to make the update on:");
                        		int projectNumberChoice = scan.nextInt();
                        		
                        		System.out.println("\nPlease enter the new project dealine(in the format DD-MM-YYYY):\"):");
                        		String newProjectDeadline = readString();
                        		
                        		//Now were communicating with MySQL.
                                rowsAffected = statement.executeUpdate(
                                        "UPDATE Projects SET Project_Deadline = '" + newProjectDeadline + "' WHERE Project_Number = " + projectNumberChoice
                                    );
                                
                                System.out.println("Project deadline successfuilly updated.\n");
                                
                                // executeQuery: runs a SELECT statement and returns the results.
                                results = statement.executeQuery("SELECT * FROM Projects");
                                // Loop over the results, printing them all.
                                while (results.next()) {
                                    System.out.println("Project number: " + results.getInt("Project_Number") + "\n" 
                                    + "Project name: "+ results.getString("Project_Name") + "\n"
                                    + "Buliding type: " + results.getString("Building_type") + "\n" 
                                    + "Project Address: " + results.getString("Project_Address") + "\n"
                                    + "EFR number: " + results.getInt("EFR_Number") + "\n" 
                                    + "Project deadline: " + results.getString("Project_Deadline") + "\n" 
                                    + "Total fee charged: R" + results.getInt("Total_Fee_Charged") + "\n"
                                    + "Total paid to date: R" + results.getInt("Total_Paid_To_Date") + "\n" 
                                    + "Status: " + results.getString("Status") + "\n"
                                    + "Completion date: " + results.getString("Completion_Date"));
                                }
                        		break;
                        		
                        	case 2:
                        		System.out.println("\nPlease enter the project number of the project that you'd like to make the update on:");
                        		int projectNumberChoice1 = scan.nextInt();
                        		
                        		System.out.println("\nPlease enter the total amount paid to date:");
                        		int newTotalPaidToDate = scan.nextInt();
                        		
                        		//Now were communicating with MySQL.
                                rowsAffected = statement.executeUpdate(
                                        "UPDATE Projects SET Total_Paid_To_Date = " + newTotalPaidToDate + " WHERE Project_Number = " + projectNumberChoice1
                                    );
                                
                                System.out.println("\nThe total amount paid has been successfuilly updated.");
                                
                                results = statement.executeQuery("SELECT * FROM Projects");
                                // Loop over the results, printing them all.
                                while (results.next()) {
                                    System.out.println("Project number: " + results.getInt("Project_Number") + "\n" 
                                    + "Project name: "+ results.getString("Project_Name") + "\n"
                                    + "Buliding type: " + results.getString("Building_type") + "\n" 
                                    + "Project Address: " + results.getString("Project_Address") + "\n"
                                    + "EFR number: " + results.getInt("EFR_Number") + "\n" 
                                    + "Project deadline: " + results.getString("Project_Deadline") + "\n" 
                                    + "Total fee charged: R" + results.getInt("Total_Fee_Charged") + "\n"
                                    + "Total paid to date: R" + results.getInt("Total_Paid_To_Date") + "\n" 
                                    + "Status: " + results.getString("Status") + "\n"
                                    + "Completion date: " + results.getString("Completion_Date"));
                                }
                        		break;
                        		
                        	case 0:
                            	System.out.println("\nProgram terminated.");  	
                            	break;
                        		
                        	default:
                        	System.out.println("/nIncorrect menu option entry. Please re-enter.");
                        	 		
                        	}
            			}while(updateChoice != 0);
            			
            		/**
            		 * If the user selects option 3(to finalise a project).	
            		 */
            		case 3:
            			System.out.println("\nPlease enter the Id number of the project that you would like to finalise.");
            			int finalisedProjId = scan.nextInt();
            			
            			//Now checking if the customer still has an outstanding amount to pay.
                        results = statement.executeQuery("SELECT Total_Paid_To_Date, Total_Fee_Charged, Customer_Name, Customer_Number, "
                        		+ "Customer_Email FROM Projects, Customers "
                        		+ "WHERE Project_Number =" + finalisedProjId + " AND Customers.Customer_Id =" + finalisedProjId);
                        
                        //Getting the current date so it can be updated into the completion_date column.
                        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");  
                        Date date = new Date();  
                        String currentDateTime =(sdf.format(date));  
                         
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {
                            int Total_fee = results.getInt("Total_Fee_Charged");
                            int Total_Paid = results.getInt("Total_Paid_To_Date");
                            String CustomerNumber = results.getString("Customer_Number");
                            String CustomerName = results.getString("Customer_Name");
                            String CustomerEmail = results.getString("Customer_Email");
                            int outstandingFee = Total_fee - Total_Paid;
                            
                            //  If the project has a customer that still needs to pay, sn invoice will be generated.
                            if(outstandingFee > 0) {
                            	System.out.println("\n----INVOICE----"
                            			+ "\nCustomer: " + CustomerName
                            			+ "\nTelephone num: " + CustomerNumber
                            			+ "\nEmail address: " + CustomerEmail
                            			+ "\nOustanding Balance: R" + outstandingFee + "\n");
                            	
                            	// Project is then finalised, the Status column is updated.
                                rowsAffected = statement.executeUpdate(
                                        "UPDATE Projects SET Status = 'Finalised' WHERE Project_Number = " + finalisedProjId
                                );
                                
                                // A completion date is also then added to the Completion date column.
                                rowsAffected = statement.executeUpdate(
                                        "UPDATE Projects SET Completion_Date = '" + currentDateTime + "' WHERE Project_Number = " + finalisedProjId
                                );
                            	
                                results = statement.executeQuery("SELECT * FROM Projects");
                                // Loop over the results, printing them all.
                                while (results.next()) {
                                    System.out.println("Project number: " + results.getInt("Project_Number") + "\n" 
                                    + "Project name: "+ results.getString("Project_Name") + "\n"
                                    + "Buliding type: " + results.getString("Building_type") + "\n" 
                                    + "Project Address: " + results.getString("Project_Address") + "\n"
                                    + "EFR number: " + results.getInt("EFR_Number") + "\n" 
                                    + "Project deadline: " + results.getString("Project_Deadline") + "\n" 
                                    + "Total fee charged: R" + results.getInt("Total_Fee_Charged") + "\n"
                                    + "Total paid to date: R" + results.getInt("Total_Paid_To_Date") + "\n" 
                                    + "Status: " + results.getString("Status") + "\n"
                                    + "Completion date: " + results.getString("Completion_Date"));
                                }	                           	
                            }
                            // If the customer of the project has paid the total fee charged, no invoice will be generated.
                            else {
                                rowsAffected = statement.executeUpdate(
                                        "UPDATE Projects SET Status = 'Finalised' WHERE Project_Number = " + finalisedProjId
                                );
                                
                                rowsAffected = statement.executeUpdate(
                                        "UPDATE Projects SET Completion_Date = '" + currentDateTime + "' WHERE Project_Number = " + finalisedProjId
                                );
                            	
                                results = statement.executeQuery("SELECT * FROM Projects");
                                // Loop over the results, printing them all.
                                while (results.next()) {
                                    System.out.println("Project number: " + results.getInt("Project_Number") + "\n" 
                                    + "Project name: "+ results.getString("Project_Name") + "\n"
                                    + "Buliding type: " + results.getString("Building_type") + "\n" 
                                    + "Project Address: " + results.getString("Project_Address") + "\n"
                                    + "EFR number: " + results.getInt("EFR_Number") + "\n" 
                                    + "Project deadline: " + results.getInt("Project_Deadline") + "\n" 
                                    + "Total fee charged: R" + results.getInt("Total_Fee_Charged") + "\n"
                                    + "Total paid to date: R" + results.getInt("Total_Paid_To_Date") + "\n" 
                                    + "Status: " + results.getString("Status") + "\n"
                                    + "Completion date: " + results.getString("Completion_Date"));
                                }
                            }
                        }
                        break;
                    /**
                     * If the user selects option 4(to see list of projects that still need to be completed).
                     * Just the project number and project name will be displayed to the user.    
                     */
            		case 4:
            			System.out.println("\nListed below is the Project Number and Project Name of projects still to be completed:\n");
                        results = statement.executeQuery("SELECT Project_Number, Project_Name FROM Projects WHERE Status = 'Incomplete'");
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {
                            System.out.println("\nProject number: " + results.getInt("Project_Number") + 
                            		"\nProject name: " + results.getString("Project_Name"));
                        }
                        break;
                        /**
                         * If the user selects option 5(to see a list of projects that are overdue).
                         * Start by getting the current date. This will be used to compare to the project 
                         * deadline.
                         */
            		case 5:
            			System.out.println("\nListed below is the Project Number and Project Name:");
                        SimpleDateFormat sdf1 = new SimpleDateFormat("DD-MM-YYYY");  
                        Date date1 = new Date();  
                        //String currentDate =(sdf1.format(date1));
                        results = statement.executeQuery("SELECT Project_Number, Project_Name, Project_Deadline FROM Projects");
                        while (results.next()) {
                        	String deadline1 = results.getString("Project_Deadline");
                        	Date d1 = sdf1.parse(deadline1);
                        
                        	if(d1.compareTo(date1) > 0) {
                                System.out.println("\nProject number: " + results.getInt("Project_Number") + 
                                		"\nProject name: " + results.getString("Project_Name"));
                        	}
                        	else {
                        		System.out.println("Currently no overdue projects.");
                        	}
                        }
                        break;
                     /**
                      * If the user selects option 6(to search for a project by entering the project number).
                      * All the data of that project for all the tables will displayed to the user. 
                      */
            		case 6:
    					System.out.println("\nEnter the project number:");
    					int projName = scan.nextInt();
                        results = statement.executeQuery("SELECT Project_Name, Building_Type, Project_Address, "
                           		+ "EFR_Number, project_Deadline, Total_Fee_Charged, Total_Paid_To_Date, Status, Completion_Date FROM Projects WHERE Project_Number = " + projName);
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {                          
                           System.out.println("Project name: "+ results.getString("Project_Name") + "\n"
                           + "Buliding type: " + results.getString("Building_type") + "\n" 
                           + "Project Address: " + results.getString("Project_Address") + "\n"
                           + "EFR number: " + results.getInt("EFR_Number") + "\n" 
                           + "Project deadline: " + results.getString("Project_Deadline") + "\n" 
                           + "Total fee charged: R" + results.getInt("Total_Fee_Charged") + "\n"
                           + "Total paid to date: R" + results.getInt("Total_Paid_To_Date") + "\n" 
                           + "Status: " + results.getString("Status") + "\n"
                           + "Completion date: " + results.getString("Completion_Date"));
                        }
                        
                        results = statement.executeQuery("SELECT Customer_Name, Customer_Number, Customer_Email, Customer_Address "
                        		+ "FROM Customers WHERE Customer_Id = " + projName);
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {                          
                           System.out.println("\nCustomer name: "+ results.getString("Customer_Name") + "\n"
            					+ "Customer phone: " + results.getInt("Customer_Number") + "\n"
            					+ "Customer email: " + results.getString("Customer_Email") + "\n"
            					+ "Customer address: " + results.getString("Customer_Address") + "\n");
                        }
                        
                        results = statement.executeQuery("SELECT Proj_Manager_Name, Proj_Manager_Number, Proj_Manager_Email, Proj_Manager_Address "
                        		+ "FROM Managers WHERE Proj_Manager_Id = " + projName);
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {                          
                           System.out.println(" Project manager name: "+ results.getString("Proj_Manager_Name") + "\n"
            					+ "Project manager phone: " + results.getInt("Proj_Manager_Number") + "\n"
            					+ "Project manager email: " + results.getString("Proj_Manager_Email") + "\n"
            					+ "Project manager address: " + results.getString("Proj_Manager_Address") + "\n");
                        }
                        
                        results = statement.executeQuery("SELECT Architect_Name, Architect_Number, Architect_Email, Architect_Address "
                        		+ "FROM Architects WHERE Architect_Id = " + projName);
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {                          
                           System.out.println(" Architect name: "+ results.getString("Architect_Name") + "\n"
            					+ "Architect phone: " + results.getInt("Architect_Number") + "\n"
            					+ "Architect email: " + results.getString("Architect_Email") + "\n"
            					+ "Architect address: " + results.getString("Architect_Address") + "\n");
                        }
                        
                        results = statement.executeQuery("SELECT Contractor_Name, Contractor_Number, Contractor_Email, Contractor_Address "
                        		+ "FROM Contractors WHERE Contractor_Id = " + projName);
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {                          
                           System.out.println("Contractor name: "+ results.getString("Contractor_Name") + "\n"
            					+ "Contractor phone: " + results.getInt("Contractor_Number") + "\n"
            					+ "Contractor email: " + results.getString("Contractor_Email") + "\n"
            					+ "Contractor address: " + results.getString("Contractor_Address") + "\n");
                        }
                        
                        results = statement.executeQuery("SELECT Struct_Engineer_Name, Struct_Engineer_Number, Struct_Engineer_Email, Struct_Engineer_Address "
                        		+ "FROM Engineers WHERE Struct_Engineer_Id = " + projName);
                        
                        // Loop over the results, printing them all.
                        while (results.next()) {                          
                           System.out.println("Engineer name: "+ results.getString("Struct_Engineer_Name") + "\n"
            					+ "Engineer phone: " + results.getInt("Struct_Engineer_Number") + "\n"
            					+ "Engineer email: " + results.getString("Struct_Engineer_Email") + "\n"
            					+ "Engineer address: " + results.getString("Struct_Engineer_Address") + "\n");
                        }
                        break;
                        /**
                         * The program will terminate.
                         */
            		case 0:
                    	System.out.println("\nProgram terminated.");  	
                    	break;
                    	
                	default:
                	System.out.println("/nIncorrect menu option entry. Please re-enter.");
                	 
            	}
            	
            }while(mainMenuChoice != 0 );
            
            connection.close();
            statement.close();
            scan.close();
           
		}
		catch(SQLException e) {
            // We only want to catch a SQLException - anything else is off-limits for now.
            e.printStackTrace(); 
            System.out.println("Sorry not found.");
		}
		
	}
	
	//This method will take in string user input as a whole and not just the first token.
	private static String readString() {
	    Scanner scanner = new Scanner(System.in);
	    return scanner.nextLine();
	}

	/**
	 * Method contains string that will communicate with mySQL to create a table.
	 */
	private static final String createTable_P = "CREATE TABLE IF NOT EXISTS Projects("
              + "Project_Number int NOT NULL AUTO_INCREMENT,"
              + "Project_Name varchar (255) NOT NULL,"
              + "Building_Type varchar (255) NOT NULL,"
              + "Project_Address varchar (255) NOT NULL,"
			  + "EFR_Number int (6) NOT NULL,"
			  + "Project_Deadline varchar (255) NOT NULL,"
			  + "Total_Fee_Charged int (20) NOT NULL,"
			  + "Total_Paid_To_Date int (20) NOT NULL,"
			  + "Status varchar (255) NOT NULL,"
			  + "Completion_Date varchar (255) NOT NULL,"
              + "PRIMARY KEY (Project_Number))";
	
	/**
	 * Method contains string that will communicate with mySQL to create a table.
	 */
    private static final String createTable_C = "CREATE TABLE IF NOT EXISTS Customers("
              + "Customer_Id int NOT NULL AUTO_INCREMENT,"
              + "Customer_Name varchar(255) NOT NULL,"
              + "Customer_Number int(255) NOT NULL,"
              + "Customer_Email varchar(255) NOT NULL,"
				+ "Customer_Address varchar (255) NOT NULL,"
              + "PRIMARY KEY (Customer_Id))";
    
	/**
	 * Method contains string that will communicate with mySQL to create a table.
	 */
    private static final String createTable_A = "CREATE TABLE IF NOT EXISTS Architects("
            + "Architect_Id int NOT NULL AUTO_INCREMENT,"
            + "Architect_Name varchar(255) NOT NULL,"
            + "Architect_Number int(255) NOT NULL,"
            + "Architect_Email varchar(255) NOT NULL,"
			+ "Architect_Address varchar (255) NOT NULL,"
            + "PRIMARY KEY (Architect_Id))";
    
	/**
	 * Method contains string that will communicate with mySQL to create a table.
	 */
    private static final String createTable_M = "CREATE TABLE IF NOT EXISTS Managers("
            + "Proj_Manager_Id int NOT NULL AUTO_INCREMENT,"
            + "Proj_Manager_Name varchar(255) NOT NULL,"
            + "Proj_Manager_Number int(255) NOT NULL,"
            + "Proj_Manager_Email varchar(255) NOT NULL,"
			+ "Proj_Manager_Address varchar (255) NOT NULL,"
            + "PRIMARY KEY (Proj_Manager_Id))";
    
	/**
	 * Method contains string that will communicate with mySQL to create a table.
	 */
    private static final String createTable_Con = "CREATE TABLE IF NOT EXISTS Contractors("
            + "Contractor_Id int NOT NULL AUTO_INCREMENT,"
            + "Contractor_Name varchar(255) NOT NULL,"
            + "Contractor_Number int(255) NOT NULL,"
            + "Contractor_Email varchar(255) NOT NULL,"
			+ "Contractor_Address varchar (255) NOT NULL,"
            + "PRIMARY KEY (Contractor_Id))";
    
	/**
	 * Method contains string that will communicate with mySQL to create a table.
	 */
    private static final String createTable_E = "CREATE TABLE IF NOT EXISTS Engineers("
            + "Struct_Engineer_Id int NOT NULL AUTO_INCREMENT,"
            + "Struct_Engineer_Name varchar(255) NOT NULL,"
            + "Struct_Engineer_Number int(255) NOT NULL,"
            + "Struct_Engineer_Email varchar(255) NOT NULL,"
			+ "Struct_Engineer_Address varchar (255) NOT NULL,"
            + "PRIMARY KEY (Struct_Engineer_Id))";
	  
    /**
     * Method printing all values in all rows.
     * Takes a statement to try to avoid spreading DB access too far.
     * 
     * @param a statement on an existing connection
     * @throws SQLException
     */
    public static void printAllFromTable(Statement statement) throws SQLException{
        
        ResultSet results = statement.executeQuery("SELECT Project_Number, Project_Name, Building_Type, Project_Address, "
        		+ "EFR_Number, Total_Fee_Charged, Total_Paid_To_Date, Status, Completion_Date, Customer_Id, "
        		+ "Customer_Name, Customer_Number, Customer_Email, Customer_Address, Architect_Id, Architect_Name, Architect_Number, "
        		+ "Architect_Email, Architect_Address, Contractor_Id, Contractor_Name, Contractor_Number, Contractor_Email, Contractor_Address, "
        		+ "Struct_Engineer_Id, Struct_Engineer_Name, Struct_Engineer_Number, Struct_Engineer_Email, Struct_Engineer_Address, Proj_Manager_Id, Proj_Manager_Name, Proj_Manager_Number, "
        		+ "Proj_Manager_Email, Proj_Manager_Address FROM Projects, Customers, "
        		+ "Architects, Contractors, Engineers, Managers");
        while (results.next()) {
            System.out.println(
                    results.getInt("Project_number") + ", "
                    + results.getString("Project_Name") + ", "
                    + results.getString("Building_Type") + ", "        
                    + results.getString("Project_Address") + ", "
                    + results.getInt("EFR_Number") + ", "
                    + results.getInt("Total_Fee_Charged") + ", "
                    + results.getInt("Total_Paid_To_Date") + ", "
                    + results.getString("Status") + ", "
                    + results.getString("Completion_Date") + ", "
                    
                    //Customer table:
					+ results.getInt("Customer_Id") + ", "
					+ results.getString("Customer_Name") + ", "
					+ results.getInt("Customer_Number") + ", "
					+ results.getString("Customer_Email") + ", "
					+ results.getString("Customer_Address") + ", "
					
					//Architect table:
					+ results.getInt("Architect_Id") + ", "
					+ results.getString("Architect_Name") + ", "
					+ results.getInt("Architect_Number") + ", "
					+ results.getString("Architect_Email") + ", "
					+ results.getString("Architect_Address") + ", "
					
					//Contractor table:
					+ results.getInt("Contractor_Id") + ", "
					+ results.getString("Contractor_Name") + ", "
					+ results.getInt("Contractor_Number") + ", "
					+ results.getString("Contractor_Email") + ", "
					+ results.getString("Contractor_Address") + ", "
					
					//Engineer table:
					+ results.getInt("Struct_Engineer_Id") + ", "
					+ results.getString("Struct_Engineer_Name") + ", "
					+ results.getInt("Struct_Engineer_Number") + ", "
					+ results.getString("Struct_Engineer_Email") + ", "
					+ results.getString("Struct_Engineer_Address") + ", "
					
					//Project manager table:
					+ results.getInt("Proj_Manager_Id") + ", "
					+ results.getString("Proj_Manager_Name") + ", "
					+ results.getInt("Proj_Manager_Number") + ", "
					+ results.getString("Proj_Manager_Email") + ", "
					+ results.getString("Proj_Manager_Address") 
					
                    
                );
        }
    }


}
