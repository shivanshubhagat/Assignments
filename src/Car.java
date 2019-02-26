/*Abstract Class for Car extended by subclasses Toyota, Maruti, Hyundai
 * @param:  Stores Car ID
 *          Type
 *          Model
 *          Price
 *          Resale value. */

public abstract class Car 
{
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

//inheriting the Car class and its variables

class Toyota extends Car
{
    //constructor of toyota class
    Toyota(String model,float price,Customer customerObj) 
    {   
        //assigning the value of type, car ID, model, price, resale value.
        type= "Toyota"; 
        carId= customerObj.carArl.size()+1;
        this.model=model; 
        this.price=price;
        resaleValue = (80*price)/100;
    }  
}

class Maruti extends Car 
{
    //constructor of maruti class
    Maruti(String model,float price,Customer customerObj) 
    {   
        //assigning the value of type, car ID, model, price, resale value.
        type= "Maruti"; 
        carId= customerObj.carArl.size()+1;
        this.model=model;
        this.price=price;
        resaleValue = (60*price)/100;

    }    
}

class Hyundai extends Car
{
    //constructor of hyundai class
    Hyundai(String model,float price,Customer customerObj) 
    {   
        //assigning the value of type, car ID, model, price, resale value.
        type= "Hyundai"; 
        carId= customerObj.carArl.size()+1;
        this.model=model;
        this.price=price;
        resaleValue =(40*price)/100;
    }
}