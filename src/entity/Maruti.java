package entity;

public class Maruti extends Car {

    //constructor of maruti class
    public Maruti(String model, float price, Customer customerObj) {
        //assigning the value of type, car ID, model, price, resale value.
        type = "Maruti";
        carId = customerObj.carArl.size() + 1;
        this.model = model;
        this.price = price;
        resaleValue = (60 * price) / 100;
    }
}
