/* NameComparator class to return the compared result of Customer Objects
 *implementing the comparator class which
 *imposes total ordering on collection of objects.*/
import java.util.Comparator;


public final class NameComparator implements Comparator<Customer> 
{
    @Override //overriding the compare function to our need
    public int compare( Customer obj1, Customer obj2) 
    {
        return obj1.customerName.compareToIgnoreCase(obj2.customerName);
    }
}     