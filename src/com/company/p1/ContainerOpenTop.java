package com.company.p1;

public class ContainerOpenTop extends ContainerHighCubePW{

    protected String openPart;

    public ContainerOpenTop(double numberContainer, double width, double height, double length, double massContainer, double widthDoors, double heightDoors, double capacity, double volume, String wares, String openPart) {
        super(numberContainer, width, height, length, massContainer, widthDoors, heightDoors, capacity, volume, wares);
        this.openPart = openPart;
    }

    public String toString() {
        return super.toString();
    }
}
