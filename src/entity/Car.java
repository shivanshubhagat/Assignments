package entity;

/*Abstract Class for Car extended by subclasses Toyota, Maruti, Hyundai
 * @param:  Stores Car ID
 *          Type
 *          Model
 *          Price
 *          Resale value. */
public abstract class Car {

    public String getModel() {
        return model;
    }

    public float getPrice() {
        return price;
    }

    public int getCarId() {
        return carId;
    }

    public String getType() {
        return type;
    }

    public float getResaleValue() {
        return resaleValue;
    }

    //each car is assigned an ID
    protected int carId;
    //3 types of available cars
    protected String type;
    //name of the model of the car
    protected String model;
    //price of the car
    protected float price;
    //calculated resale value of the car
    protected float resaleValue;
}
