// NameComparator class to return the compared result of Customer Objects

import java.util.Comparator;

public class NameComparator implements Comparator<Customer> //implementing the comparator class which imposes total ordering on collection of objects
{
    @Override //overriding the compare function to our need
    public int compare( Customer obj1, Customer obj2) 
    {
        return obj1.customerName.compareToIgnoreCase(obj2.customerName);
    }
}    