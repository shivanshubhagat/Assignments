// Customer class which contains customer data: customer ID  and Name.
// contains array list for storing objects of car type

import java.util.ArrayList;

public class Customer {
    //stores objects of type car
    ArrayList<Car> carArl = new ArrayList<>(); 
   
    //customer ID
    int customerId; 
    //Customer Name
    String customerName; 

    @Override
    //returns string representation of the object
    public String toString()  
    {
        return "Customer{" + "customerName=" + customerName + '}';
    }
   
    //constructor accepting Name as parameter
    Customer(String name) 
    {
        //assigning value to customer name
        this.customerName=name; 
    }
   
    //constructor accepting ID as parameter
    Customer(int customerId) 
    {
        //assigning value to customer id
        this.customerId=customerId; 
    }
    
    //display customer info
    public void getCustomer() 
    {
        System.out.println("Customer's ID : "+ customerId+"\nCustomer's Name : "+customerName);
    }
}