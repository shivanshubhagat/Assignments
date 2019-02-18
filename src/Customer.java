// Customer class which contains customer data: customer ID  and Name.
// contains array list for storing objects of car type

import java.util.ArrayList;

public class Customer {
    ArrayList<Car> carArl = new ArrayList<>(); //stores objects of type car
   
    int customerId; //customer ID
    String customerName; //Customer Name

    @Override
    public String toString() //returns string representation of the object 
    {
        return "Customer{" + "customerName=" + customerName + '}';
    }
   
   Customer(String name) //constructor accepting Name as parameter
   {
       this.customerName=name; //assigning value to customer name
   }
   
   Customer(int customerId) //constructor accepting ID as parameter
   {
       this.customerId=customerId; //assigning value to customer id
   }
   public void getCustomer() //display customer info
   {
       System.out.println("Customer's ID : "+ customerId+"\nCustomer's Name : "+customerName);
   }
}