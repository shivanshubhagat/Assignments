//Main class that will drive all the functions and classes. 
//Contains single main method with switch case UI.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) //Main function to call all the classes.
    {   boolean switchFlag = false; //when turned true, the switch statement will break.
        do
        {
            System.out.println("1. Add New Customer. ");
            System.out.println("2. Add New Car to Existing Customer. ");
            System.out.println("3. Show All Customers with Cars. ");
            System.out.println("4. Search Customer by ID. ");
            System.out.println("5. Generate Prizes. ");
            System.out.println("6. Exit.");
            Scanner sc = new Scanner(System.in); //input variable for scanner class
            int choice = 0 ; //variable for switch case choice
            try
            {
               int userInput = sc.nextInt(); //temporary variable to verify the switch case input 
                if (userInput>=1 && userInput<=6)
                {
                  choice = userInput;  
                }
                else
                    System.out.println("\nChoice not valid. Choose from the given options\n");
            }
            catch(InputMismatchException e)
            {
                System.out.println("\nPlease enter a valid choice.\n ");
            }
            
            Admin admin = new Admin(); //new admin object in which further respective methods are called
            switch (choice) 
            {        
                case 1:
                    String customerName = ""; //name of the customer
                    System.out.println("Enter Name of Customer. ");
                    do 
                    {
                        String nameInput = sc.next(); //temporary variable for verification
                        if (!nameInput.matches("[a-zA-Z_]+")) //regex code for varification
                        {
                            System.out.println("Name can not contain digits. "
                                    + "Please enter a Valid name. ");
                        }
                        else
                            customerName=nameInput.trim(); //storing a valid name 
                    }
                    while(customerName.isEmpty());
                    
                    Customer customer = new Customer(customerName); //new customer object in which further respective functions are called
                    int customerId = admin.addNewCustomer(customer); //the function returns the id of customer which is stored here

                    System.out.println("Enter Car Details: ");
                    admin.enterCarDetails(customerId,customer); //function to add car details to customer

                    System.out.println("\nDetails added.");
                    break;

                case 2:
                    System.out.println("Enter the Customer ID.");
                    int customerIdInput = sc.nextInt(); //non verified input for customer ID
                    if(customerIdInput<=admin.customerArl.size()) //verification of ID
                    {
                        System.out.println("Customer found");
                        admin.enterCarDetails(customerIdInput, admin.customerArl.get(customerIdInput-1)); //input details of car
                        System.out.println("Details added.\n");
                    }
                    else
                        System.out.println("Customer not found");
                    break;

                case 3:
                    admin.showNameSortedDatabase(); //show the database of all customers sorted by the name of customer
                    break;
                    
                case 4:
                    int idVerified = 0; //intialize variable for verified Customer ID
                    System.out.println("Enter the ID.");
                    do 
                    {
                        String idInput = sc.next(); //non verified ID variable
                        if (idInput.matches("[a-zA-Z_]+")) //verification of ID
                        {
                            System.out.println("ID can not contain alphabets. Please enter a Valid ID. ");
                        }
                         else if (idInput.equals("0"))
                        {
                            System.out.println("Zero ID is not valid.");
                        }
                        else
                            idVerified = Integer.parseInt(idInput); //assigning value of verified ID
                    }
                    while(idVerified==0);
                    admin.searchById(idVerified); //method to search customer by ID
                    break;
                case 5:
                    while (true)
                            {
                                try
                                {
                                    admin.generatePrizes(); //method to generate prizes
                                    break;
                                }
                                catch (InputMismatchException e)
                                {
                                    System.out.println("enter valid id");
                                }
                            }
                    break;        
                case 6:
                    System.out.println("Thank You"); //EXIT case
                    switchFlag = true;
                    break;
            }
                
        }
            while (switchFlag==false); //Loop for switch statement
    }
}    

