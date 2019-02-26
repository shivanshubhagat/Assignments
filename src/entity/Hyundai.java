package entity;

public class Hyundai extends Car {

    //constructor of hyundai class
    public Hyundai(String model, float price, Customer customerObj) {
        //assigning the value of type, car ID, model, price, resale value.
        type = "Hyundai";
        carId = customerObj.carArl.size() + 1;
        this.model = model;
        this.price = price;
        resaleValue = (40 * price) / 100;
    }
}
