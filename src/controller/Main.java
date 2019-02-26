package controller;

//Main class that will drive all the functions and classes. 
//Contains single main method with switch case UI.
import entity.Customer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Main function to call all the classes.
    public static void main(String[] args) {
        //when turned true, the switch statement will break.
        boolean switchFlag = false;
        do {
            System.out.println("1. Add New Customer. ");
            System.out.println("2. Add New Car to Existing Customer. ");
            System.out.println("3. Show All Customers with Cars. ");
            System.out.println("4. Search Customer by ID. ");
            System.out.println("5. Generate Prizes. ");
            System.out.println("6. Exit.");
            //input variable for scanner class
            Scanner sc = new Scanner(System.in);
            //variable for switch case choice
            int choice = 0;
            try {
                //temporary variable to verify the switch case input 
                int userInput = sc.nextInt();
                if (userInput >= 1 && userInput <= 6) {
                    choice = userInput;
                } else {
                    System.out.println("\nChoice not valid. Choose from the given options\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter a valid choice.\n ");
            }

            //new admin object in which further respective methods are called
            Admin admin = new Admin();
            switch (choice) {
                case 1:
                    //name of the customer
                    String customerName = "";
                    System.out.println("Enter Name of Customer. ");
                    do {
                        //temporary variable for verification
                        String nameInput = sc.next();
                        //regex code for varification
                        if (!nameInput.matches("[a-zA-Z_]+")) {
                            System.out.println("Name can not contain digits. "
                                    + "Please enter a Valid name. ");
                        } else {
                            customerName = nameInput.trim(); //storing a valid name 
                        }
                    } while (customerName.isEmpty());

                    //new customer object in which further respective functions are called
                    Customer customer = new Customer(customerName);
                    //the function returns the id of customer which is stored here
                    int customerId = admin.addNewCustomer(customer);

                    System.out.println("Enter Car Details: ");
                    //function to add car details to customer
                    admin.enterCarDetails(customerId, customer);

                    System.out.println("\nDetails added.");
                    break;

                case 2:
                    System.out.println("Enter the Customer ID.");
                    //non verified input for customer ID
                    int customerIdInput = sc.nextInt();
                    //verification of ID
                    if (customerIdInput <= admin.customerArl.size()) {
                        System.out.println("Customer found");
                        //input details of car
                        admin.enterCarDetails(customerIdInput, admin.customerArl.get(customerIdInput - 1));
                        System.out.println("Details added.\n");
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;

                case 3:
                    //show the database of all customers sorted by the name of customer
                    admin.showNameSortedDatabase();
                    break;

                case 4:
                    //intialize variable for verified Customer ID
                    int idVerified = 0;
                    System.out.println("Enter the ID.");
                    do {
                        //non verified ID variable
                        String idInput = sc.next();
                        if (idInput.matches("[a-zA-Z_]+")) //verification of ID
                        {
                            System.out.println("ID can not contain alphabets. Please enter a Valid ID. ");
                        } else if (idInput.equals("0")) {
                            System.out.println("Zero ID is not valid.");
                        } else {
                            idVerified = Integer.parseInt(idInput); //assigning value of verified ID
                        }
                    } while (idVerified == 0);
                    //method to search customer by ID
                    admin.searchById(idVerified);
                    break;
                case 5:
                    while (true) {
                        try {
                            //method to generate prizes
                            admin.generatePrizes();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("enter valid id");
                        }
                    }
                    break;
                case 6:
                    //EXIT case
                    System.out.println("Thank You");
                    switchFlag = true;
                    break;
            }

        } //Loop for switch statement
        while (switchFlag == false);
    }
}
