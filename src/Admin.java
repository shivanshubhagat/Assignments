/*Administrator class which stores Customer ArrayList which stores
 *objects of customer type.
 * @functions : addNewCustomer : add new customer to Arraylist
 *              enterCarDetails: will ask for Car type,model price
 *              addNewCarToExistingCustomer: ask customer id and run enterCarDetails
 *              showNameSortedDatabase: Show all customers sorted by name
 *              searchById: Ask for ID and show respecive customer
 *              generatePrizes: Ask for 3 IDs from Admin and Generate prizes if any id matches
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin
{
    //arrarylist of customer type object
    static ArrayList<Customer> customerArl = new ArrayList<>();
    
    //Addition of a customer type object into the arraylist
    public int addNewCustomer(Customer c)
    {
        customerArl.add(c);
        //assigning value to customer ID
        c.customerId=customerArl.indexOf(c)+1 ; 
        //returning of customer id
        return c.customerId;
    }
    
    
    public static void enterCarDetails(int customerId,Customer c)
    {
        System.out.println("Enter Car Type, Model, Price. ");
        Scanner sc = new Scanner(System.in); 
        //verified Car Type variable
        String carType = ""; 
        do
        {
            //input for non verified cartype
            String carTypeInput = sc.next(); 
            //verification of cartype
            if (carTypeInput.trim().equalsIgnoreCase("toyota") ||carTypeInput.trim().equalsIgnoreCase("hyundai") ||carTypeInput.trim().equalsIgnoreCase("maruti"))
            {
                //assigning the verified value of car type
                carType = carTypeInput;
            }
            else
                System.out.println("Invalid Type.");
        }
        //loop to get verified car type
        while (carType.isEmpty());
        
        //input for car model
        String carModel = sc.next(); 
        
        //initialize carprice
        float carPrice = 0; 
        do 
        {   
            //non verified car price
            String carPriceInput = sc.next();
            try 
            {
                //verification of car price and input
                carPrice = Float.parseFloat(carPriceInput); 
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
                //taking input and storing in toyota constructor
                Toyota t = new Toyota(carModel,carPrice,c);
                //adding the verified details of car in car arraylist
                c.carArl.add(t); 
                break;
                
            case "maruti":
                
                //taking input and storing in maruti constructor
                Maruti m = new Maruti(carModel,carPrice,c);  
                //adding the verified details of car in car arraylist
                c.carArl.add(m); 
                break;
                
            case "hyundai":
                //taking input and storing in hyundai constructor
                Hyundai h = new Hyundai(carModel,carPrice,c); 
                //adding the verified details of car in car arraylist
                c.carArl.add(h); 
                break;
            
            default:
                System.out.println("Enter Valid Data. \n");
        }
    }

    //adding new car to existing customer
    public void addNewCarToExistingCustomer(Customer c, Car car) 
    {
        //adding the details of car to the user given customer ID
        customerArl.get (customerArl.indexOf(c)). carArl.add(car); 
    }   
    
    //show database of customer sorted by name
    public void  showNameSortedDatabase() 
    {
        //sorting using name comparator
        customerArl.sort(new NameComparator());
          //iterating customer arraylist
          for(Customer c: customerArl) 
            {   System.out.println("-------------------");
                System.out.println("CustomerName: "+c.customerName+ 
                                   "\nCustomer ID: "+ c.customerId);
                //iterating car arraylist
                for(Car carObj:c.carArl) 
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
    
    //taking ID as input to search for the respective customer
    public void searchById(int id)
    {
        if(customerArl.isEmpty()) 
                System.out.println("No customer added yet.");
        else
        {   
            //check if customer is there
            for (int customerArlIndex=0; customerArlIndex<customerArl.size();customerArlIndex++) 
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
    
    //generate max. 3 random customer IDs who will get prize
    public void generatePrizes() throws InputMismatchException 
    {   
        //admin have to give 3 random IDs
        System.out.println("\nAdmin must enter 3 Valid IDs. \n"); 
                    System.out.println("Enter Id 1:\n");
                    //input ID 1
                    int adminInputId1 = new Scanner(System.in).nextInt(); 
                    
                    System.out.println("Enter Id 2:\n");
                    //input ID 2
                    int adminInputId2 = new Scanner(System.in).nextInt(); 
                    
                    System.out.println("Enter Id 3:\n");
                    //input ID 3
                    int adminInputId3 = new Scanner(System.in).nextInt(); 
                    
        if (customerArl.isEmpty())
        {
            System.out.println("You have no customer yet,so no winner.\n");
        }
        //generating 6 random IDs from the databse already present
        else 
        {
            //storing the 6 randomly generated IDs
            ArrayList <Integer> sixNumberArl = new ArrayList<>(); 
            for (int sixNumberArlIndex=0;sixNumberArlIndex<6;sixNumberArlIndex++)
            {
                sixNumberArl.add((int)(Math.random()*customerArl.size()+1));
            }

            //arraylist for adding winners IDs, if any
            ArrayList <Integer> winnersArl = new ArrayList<>(); 
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
