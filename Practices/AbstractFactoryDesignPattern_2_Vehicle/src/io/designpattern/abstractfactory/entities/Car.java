package io.designpattern.abstractfactory.entities;

public class Car implements Vehicle{
    @Override
    public void showVehicleType() {
        System.out.println("Vehicle: Car");
    }
}
