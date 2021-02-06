package com.company.p1;

public class StandartContainer {

    protected double numberContainer;
    protected double width;
    protected double height;
    protected double length;
    protected double massContainer;
    protected double widthDoors;
    protected double heightDoors;
    protected double capacity; //ładowność
    protected double volume; //pojemność
    protected String wares;

    public StandartContainer(double numberContainer, double width, double height, double length, double massContainer, double widthDoors, double heightDoors, double capacity, double volume, String wares){
        this.numberContainer = numberContainer;
        this.width = width;
        this.height = height;
        this.length = length;
        this.massContainer = massContainer;
        this.widthDoors = widthDoors;
        this.heightDoors = heightDoors;
        this.capacity = capacity;
        this.volume = volume;
        this.wares = wares;
    }

    public double getHeight(){
        return height;
    }

    public double getLength(){
        return length;
    }

    public double getMassContainer(){
        return massContainer;
    }

    public double getWidthDoors(){
        return widthDoors;
    }

    public double getHeightDoors(){
        return heightDoors;
    }

    public double getCapacity(){
        return capacity;
    }

    public double getVolume(){
        return volume;
    }

    public String getWares(){
        return wares;
    }

    @Override
    public String toString() {
        return  numberContainer + "," +
                width + "," +
                height + "," +
                length + "," +
                massContainer + "," +
                widthDoors + "," +
                heightDoors + "," +
                capacity + "," +
                volume + "," +
                wares;
    }
/*
    public String toString() {
        return  " width " + width +
                " height " + height +
                " length " + length +
                " massContainer " + massContainer +
                " widthDoors " + widthDoors +
                " heightDoors " + heightDoors +
                " capacity " + capacity +
                " volume " + volume +
                " wares " + wares;
    }\

 */
}
