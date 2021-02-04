package io.designpattern.abstractfactory;


import io.designpattern.abstractfactory.color.Color;
import io.designpattern.abstractfactory.entities.Vehicle;
import io.designpattern.abstractfactory.factory.AbstractFactory;
import io.designpattern.abstractfactory.factory.FactoryProducer;

public class Demo {
    public static void main(System args[]){
        AbstractFactory vehicleFactory = FactoryProducer.getFactory("VEHICLE");

        Vehicle car = vehicleFactory.getVehicle("Car");
        car.draw();
        Vehicle motorCycle = vehicleFactory.getVehicle("MotorCycle");
        motorCycle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Color redColor = colorFactory.getColor("RED");
        redColor.fill();
        Color blueColor = colorFactory.getColor("BLUE");
        blueColor.fill();


    }
}
