package io.AbstractFactoryDesignPattern.Factory;

import io.AbstractFactoryDesignPattern.Entities.*;
import io.AbstractFactoryDesignPattern.Entities.Shape;

// Create Factory classes extending Factory.AbstractFactory to generate object of
// concrete class based on given information.
public class ShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
