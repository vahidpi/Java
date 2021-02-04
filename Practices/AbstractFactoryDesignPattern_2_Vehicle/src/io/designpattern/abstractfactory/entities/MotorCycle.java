package io.designpattern.abstractfactory.entities;

public class MotorCycle implements Vehicle{
    @Override
    public void showVehicleType() {
        System.out.println("Vehicle: MotorCycle");
    }
}
