package edu.greenriver.it.visualdata.view_model;

import edu.greenriver.it.visualdata.model.Car;

/**
 * Created by ebenn on 11/2/2017.
 */

public class CarViewModel {
    //Model Object
    Car _car;

    //Constructor
    public CarViewModel(Car car) {
        _car = car;
    }

    //Some logic/function
    //Create a function that displays the current owner + year of the car in one string
    public String getOwnerAndYear() {
        return _car.currentOwner.name + " " + _car.year;
    }
}
