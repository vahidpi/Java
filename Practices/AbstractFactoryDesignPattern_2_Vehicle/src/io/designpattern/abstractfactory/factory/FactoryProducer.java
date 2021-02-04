package io.designpattern.abstractfactory.factory;

import io.designpattern.abstractfactory.color.*;
import io.designpattern.abstractfactory.entities.*;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equals("VEHICLE")) {
            return new VehicleFactory();
        } else if (choice.equals("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
