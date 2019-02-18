//Abstract Class for Car extended by subclasses Toyota, Maruti, Hyundai
//Stores Car ID, Type, Model, Price, Resale value.

public abstract class Car 
{
    protected int carId; //each car is assigned an ID
    protected String type; //3 types of available cars
    protected String model; //name of the model of the car
    protected float price; //price of the car
    protected float resaleValue; //calculated resale value of the car
}

class Toyota extends Car
{
    Toyota(String model,float price,Customer customerObj) //constructor of toyota class
    {   type= "Toyota"; //assigning the value of type, car ID, model, price, resale value.
        carId= customerObj.carArl.size()+1;
        this.model=model; 
        this.price=price;
        resaleValue = (80*price)/100;
    }  
}

class Maruti extends Car //inheriting the Car class and its variables
{
    Maruti(String model,float price,Customer customerObj) //constructor of maruti class
    {   type= "Maruti"; //assigning the value of type, car ID, model, price, resale value.
        carId= customerObj.carArl.size()+1;
        this.model=model;
        this.price=price;
        resaleValue = (60*price)/100;

    }    
}

class Hyundai extends Car
{
    Hyundai(String model,float price,Customer customerObj) //constructor of hyundai class
    {   type= "Hyundai"; //assigning the value of type, car ID, model, price, resale value.
        carId= customerObj.carArl.size()+1;
        this.model=model;
        this.price=price;
        resaleValue =(40*price)/100;
    }
}