package io.designpattern.abstractfactory.color;

public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Color : Red");
    }
}
