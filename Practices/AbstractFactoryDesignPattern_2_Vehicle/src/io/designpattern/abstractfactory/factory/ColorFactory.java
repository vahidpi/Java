package io.designpattern.abstractfactory.factory;

import io.designpattern.abstractfactory.color.Color;
import io.designpattern.abstractfactory.color.*;

public abstract class ColorFactory extends AbstractFactory{
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equals("RED")) {
            return new Red();
        } if (color.equals("BLUE")) {
            return new Blue();
        }
        return null;
    }
}
