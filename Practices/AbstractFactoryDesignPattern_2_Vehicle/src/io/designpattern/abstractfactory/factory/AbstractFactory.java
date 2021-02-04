package io.designpattern.abstractfactory.factory;

import io.designpattern.abstractfactory.color.Color;
import io.designpattern.abstractfactory.entities.Vehicle;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Vehicle getVehicle(String vehicleType);
}