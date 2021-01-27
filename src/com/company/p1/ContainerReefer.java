package com.company.p1;

public class ContainerReefer extends StandartContainer{

    protected double temperature;
    protected String hermtic;

    public ContainerReefer(double temperature, double numberContainer, double width, double height, double length, double massContainer, double widthDoors, double heightDoors, double capacity, double volume, String wares) {
        super(numberContainer, width, height, length, massContainer, widthDoors, heightDoors, capacity, volume, wares);
        this.temperature = temperature;
    }

    public String toString() {
        return super.toString();
    }
}
