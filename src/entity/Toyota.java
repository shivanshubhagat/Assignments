package entity;

public class Toyota extends Car {

    //constructor of toyota class
    public Toyota(String model, float price, Customer customerObj) {
        //assigning the value of type, car ID, model, price, resale value.
        type = "Toyota";
        carId = customerObj.carArl.size() + 1;
        this.model = model;
        this.price = price;
        resaleValue = (80 * price) / 100;
    }
}
