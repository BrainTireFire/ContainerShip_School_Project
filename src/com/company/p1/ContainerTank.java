package com.company.p1;

public class ContainerTank extends ContainerReefer{

    private double pressure;

    public ContainerTank(double temperature, double numberContainer, double width, double height, double length, double massContainer, double widthDoors, double heightDoors, double capacity, double volume, String wares) {
        super(temperature, numberContainer, width, height, length, massContainer, widthDoors, heightDoors, capacity, volume, wares);

    }

    public String toString() {
        return super.toString();
    }
}
