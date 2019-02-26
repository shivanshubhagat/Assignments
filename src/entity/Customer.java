package entity;

// Customer class which contains customer data: customer ID  and Name.
// contains array list for storing objects of car type
import java.util.ArrayList;

public class Customer {

    //stores objects of type car
    public ArrayList<Car> carArl = new ArrayList<>();

    //customer ID
    public int customerId;
    //Customer Name
    public String customerName;

    @Override
    //returns string representation of the object
    public String toString() {
        return "Customer{" + "customerName=" + customerName + '}';
    }

    //constructor accepting Name as parameter
    public Customer(String name) {
        //assigning value to customer name
        this.customerName = name;
    }

    //constructor accepting ID as parameter
    Customer(int customerId) {
        //assigning value to customer id
        this.customerId = customerId;
    }

    //display customer info
    public void getCustomer() {
        System.out.println("Customer's ID : " + customerId + "\nCustomer's Name : " + customerName);
    }
}
