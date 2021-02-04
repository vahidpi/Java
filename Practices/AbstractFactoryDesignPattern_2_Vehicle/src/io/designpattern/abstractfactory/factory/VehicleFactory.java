package io.designpattern.abstractfactory.factory;

import io.designpattern.abstractfactory.entities.*;
import io.designpattern.abstractfactory.entities.Vehicle;

public abstract class VehicleFactory extends AbstractFactory {
    @Override
    public Vehicle getVehicle(String vehicleType){
        if(vehicleType == null){
            return null;
        } else if(vehicleType.equals("Car")){
            return new Car();
        } else if(vehicleType.equals("MotorCycle")){
            return new MotorCycle();
        }
        return null;
    }
}
