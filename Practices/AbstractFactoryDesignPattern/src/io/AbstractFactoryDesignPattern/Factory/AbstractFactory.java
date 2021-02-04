package io.AbstractFactoryDesignPattern.Factory;

import io.AbstractFactoryDesignPattern.Entities.Shape;

// Create an Abstract class to get factories for Normal and Rounded Shape Objects.
public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType) ;
}
