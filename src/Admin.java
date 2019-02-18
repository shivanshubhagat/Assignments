//Administrator class which stores Customer ArrayList which stores objects of customer type.
/* @functions : addNewCustomer, enterCarDetails, addNewCarToExistingCustomer,
showNameSortedDatabase, searchById, generatePrizes*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin 
{
    static ArrayList<Customer> customerArl = new ArrayList<>(); //arrarylist of customer type object
    
    public int addNewCustomer(Customer c) //Addition of a customer type object into the arraylist
    {
        customerArl.add(c);
        c.customerId=customerArl.indexOf(c)+1 ; //assigning value to customer ID
        return c.customerId; //returning of customer id
    }
    
    public static void enterCarDetails(int customerId,Customer c) //asking the car details
    {
        System.out.println("Enter Car Type, Model, Price. ");
        Scanner sc = new Scanner(System.in); //new object of scanner class
        String carType = ""; //verified Car Type variable
        do
        {
            String carTypeInput = sc.next(); //input for non verified cartype
            if (carTypeInput.trim().equalsIgnoreCase("toyota") ||carTypeInput.trim().equalsIgnoreCase("hyundai") ||carTypeInput.trim().equalsIgnoreCase("maruti")) //verification of cartype
            {
                carType = carTypeInput; //assigning the verified value of car type
            }
            else
                System.out.println("Invalid Type.");
        }
        while (carType.isEmpty()); //loop to get verified car type
        
        String carModel = sc.next(); //input for car model
        
        float carPrice = 0; //initialize carprice
        do 
        {   
            String carPriceInput = sc.next(); //non verified car price
            try 
            {
                carPrice = Float.parseFloat(carPriceInput); //verification of car price and input
            }
            catch (NumberFormatException e) 
            {
                System.out.println("Input was not in Numeric form. Please Enter price again");
            }
        }
        while (carPrice == 0);
        
        switch (carType.toLowerCase()) 
        {
            case "toyota":
                Toyota t = new Toyota(carModel,carPrice,c); //taking input and storing in toyota constructor
                c.carArl.add(t); //adding the verified details of car in car arraylist
                break;
                
            case "maruti":
                Maruti m = new Maruti(carModel,carPrice,c);  //taking input and storing in maruti constructor
                c.carArl.add(m); //adding the verified details of car in car arraylist
                break;
                
            case "hyundai":
                Hyundai h = new Hyundai(carModel,carPrice,c);  //taking input and storing in hyundai constructor
                c.carArl.add(h); //adding the verified details of car in car arraylist
                break;
            
            default:
                System.out.println("Enter Valid Data. \n");
        }
    }

    
    public void addNewCarToExistingCustomer(Customer c, Car car) //adding new car to existing customer
    {
        customerArl.get (customerArl.indexOf(c)). carArl.add(car); //adding the details of car to the user given customer ID
    }   
    
       
    
    public void  showNameSortedDatabase() //show database of customer sorted by name
    {
        customerArl.sort(new NameComparator()); //sorting using name comparator
          for(Customer c: customerArl) //iterating customer arraylist
            {   System.out.println("-------------------");
                System.out.println("CustomerName: "+c.customerName+ 
                                   "\nCustomer ID: "+ c.customerId);
                for(Car carObj:c.carArl) //iterating car arraylist
                {   
    
                    System.out.println( "Car ID:" + carObj.carId +
                            "\nType:"+ carObj.type +
                            "\nModel: "+ carObj.model +
                            "\nPrice: "+ carObj.price +
                            "\nResale Price: " + carObj.resaleValue);
                }
                System.out.println("-------------------");
            }
    }
    
    public void searchById(int id) //taking ID as input to search for the respective customer
    {
        if(customerArl.isEmpty()) 
                System.out.println("No customer added yet.");
        else
        {    
            for (int customerArlIndex=0; customerArlIndex<customerArl.size();customerArlIndex++) //check if customer is there
            {
                if (customerArl.get(customerArlIndex).customerId == id ) 
                {
                     System.out.println("-------------------");
                    System.out.println("Customer ID: "+id+ 
                                       "\nCustomer Name: "+ customerArl.get(customerArlIndex).customerName);
                    for(Car carObj:customerArl.get(customerArlIndex).carArl)
                    {   

                        System.out.println("\nCar ID: "+ carObj.carId +
                                "\nType:"+ carObj.type +
                                "\nModel: "+ carObj.model +
                                "\nPrice: "+ carObj.price +
                                "\nResale Price: " + carObj.resaleValue);
                    }
                    System.out.println("-------------------");
                }
                else
                    System.out.println("Customer with this ID not found. Try Again.\n");
            }
        }    
    }
    
    public void generatePrizes() throws InputMismatchException //generate max. 3 random customer IDs who will get prize
    {   
        System.out.println("\nAdmin must enter 3 Valid IDs. \n"); //admin have to give 3 random IDs
                    System.out.println("Enter Id 1:\n");
                    int adminInputId1 = new Scanner(System.in).nextInt(); //input ID 1
                    
                    System.out.println("Enter Id 2:\n");
                    int adminInputId2 = new Scanner(System.in).nextInt(); //input ID 2
                    
                    System.out.println("Enter Id 3:\n");
                    int adminInputId3 = new Scanner(System.in).nextInt(); //input ID 3
                    
        if (customerArl.isEmpty())
        {
            System.out.println("You have no customer yet,so no winner.\n");
        }
        else //generating 6 random IDs from the databse already present
        {
            ArrayList <Integer> sixNumberArl = new ArrayList<>(); //storing the 6 randomly generated IDs
            for (int sixNumberArlIndex=0;sixNumberArlIndex<6;sixNumberArlIndex++)
            {
                sixNumberArl.add((int)(Math.random()*customerArl.size()+1));
            }

            ArrayList <Integer> winnersArl = new ArrayList<>(); //arraylist for adding winners IDs, if any
            if ( sixNumberArl.contains(adminInputId1))
            {
                winnersArl.add(adminInputId1);
            }
            if ( sixNumberArl.contains(adminInputId2))
            {
                winnersArl.add(adminInputId2);
            }
            if ( sixNumberArl.contains(adminInputId3))
            {
                winnersArl.add(adminInputId3);
            }
            if (winnersArl.isEmpty())
                System.out.println("Sorry, No Winner");      
            else
                System.out.println("Winners are: " + winnersArl + "\nCONGRATULATIONS");
        }
    }
}
