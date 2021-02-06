package com.company.p3;

import com.company.p2.Node;

import java.io.*;
import java.util.ArrayList;

public class ContainerShip {

    private String nameOfShip;
    private double width;
    private double height;
    private double length;
    private double maxMassCapacity;
    private char[] rowContainerPlace = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String idContainerPlace;

    //Zmienne do dzialan
    private String[] arrayTemp;
    private String result = new String();
    private double massRight;
    private int indexRightCount;
    private int indexRowConitanerRight;
    private double massLeft;
    private int indexLeftCount;
    private int indexRowConitanerLeft;
    private int placeContainerLeft = 0; // miejsce kontenera po z
    private int placeContainerRight = 0; // miejsce kontenera po z
    private int idUpContainerPlaceLeft = 0;
    private int idUpContainerPlaceRight = 0;

    public ContainerShip(String nameOfShip, double width, double height, double length, double maxMassCapacity){
        this.nameOfShip = nameOfShip;
        this.width = width;
        this.height = height;
        this.length = length;
        this.maxMassCapacity = maxMassCapacity;
        arrayTemp = new String[10];

        //Potrzebne do dzialan
        massRight = 0;
        indexRightCount = 0;
        indexRowConitanerRight = rowContainerPlace.length-1;
        massLeft = 0;
        indexLeftCount = 0;
        indexRowConitanerLeft = 0;
    }

    private String loadingContainer(){
        int controler = 0;
        String tmp = new String();

        if(massLeft <= massRight){
            controler = 0;
        }else{
            controler = 1;
        }

        switch (controler) {
            case 0:
                    tmp = containerLeftSide();
                break;
            case 1:
                    tmp = containerRightSide();
                break;
            default:
                break;
        }
        return tmp;
    }

    //Getting from file data
    public void createManifest(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("containerList.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Manifest.txt"));
            String line;
            while( (line = br.readLine()) != null){
               String[] vals = line.split(",");
               for (int i=0;i<10;i++) {
                   extendArray(arrayTemp);
                   arrayTemp[i] = vals[i];
               }
               bw.write(loadingContainer());
            }
            br.close();
            bw.flush();
            bw.close();
            Thread.sleep(1000);
            System.out.println("Kontenery zostały ułozone w porzadku bezpieczny dla statku.");
            Thread.sleep(1000);
            System.out.println("Manifest został utworzony");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String[] extendArray(String[] arr){
        String[] tmp = new String[arrayTemp.length * 2];

        for (int i=0; i<arr.length; i++)
            tmp[i] = arr[i];

        return tmp;
    }

    // Right side of Container Ship
    private String containerRightSide(){
        double massTemp = Double.parseDouble(arrayTemp[4]);

        massRight += massTemp;
        if (indexRightCount <= 625) {
            containerRightRowUp();
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerRight]) + String.valueOf(idUpContainerPlaceRight) + String.valueOf(placeContainerRight);
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
            placeContainerRight++;
            indexRightCount++;
        }else {
            indexRowConitanerRight--;
            indexRightCount = 0;
        }

        return result;
    }

    private void containerRightRowUp(){
        if (placeContainerRight > 25){
            if (idUpContainerPlaceRight > 24)
                idUpContainerPlaceRight = 0;
            idUpContainerPlaceRight++;
            placeContainerRight = 1;
        }
    }

    private void containerLeftRowUp(){
        if (placeContainerLeft > 25){
            if (idUpContainerPlaceLeft > 24)
                idUpContainerPlaceLeft = 0;
            idUpContainerPlaceLeft++;
            placeContainerLeft = 1;
        }
    }

    // Left side of Container Ship
    private String containerLeftSide(){
        double massTemp = Double.parseDouble(arrayTemp[4]);

        massLeft += massTemp;
        if (indexLeftCount <= 625) {
            containerLeftRowUp();
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerLeft]) + String.valueOf(idUpContainerPlaceLeft) + String.valueOf(placeContainerLeft);
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
            placeContainerLeft++;
            indexLeftCount++;
        } else {
            indexRowConitanerLeft++;
            indexLeftCount = 0;
        }

        return result;
    }

    private double roundTo2DecimalPlace(double value) {
        return Math.round(value * 100) / 100;
    }

/*
  private String containerLeftSide(){
        double massTemp = Double.parseDouble(arrayTemp[4]);

        massLeft += massTemp;
        if (indexLeftCount <= 625) {
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerLeft])+ String.valueOf(rowUpContainerPlace[idUpContainerPlaceLeft]) + String.valueOf(placeContainerLeft);
            test();
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
            placeContainerLeft++;
            indexLeftCount++; //
        } else {
            indexRowConitanerLeft++;
            placeContainerLeft = 0;
            indexLeftCount = 0;
        }

        return result;
    }

massRight += massTemp;
        if (indexRightCount <= 1000) {
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerRight]) + String.valueOf(indexContainer);
            indexRightCount++;
            indexContainer++;
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
        } else {
            if(indexRowConitanerRight < 14)
                indexRowConitanerRight++;
            else
                indexRowConitanerRight--;

            indexContainer++;
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerRight]) + String.valueOf(indexContainer);
            indexRightCount++;
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
        }


   try {
            BufferedReader br = new BufferedReader(new FileReader("containerList.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Manifest.txt"));

            String line;
            while( (line = br.readLine()) != null){
               String[] vals = line.split(",");
                double numberContainer = Double.parseDouble(vals[0]);
                String width = vals[1];
                String height =  vals[2];
                String length = vals[3];
                double massContainer = Double.parseDouble(vals[4]);
                String widthDoors = vals[5];
                String heightDoors = vals[6];
                String capacity = vals[7];
                String volume = vals[8];
                String wares = vals[9];

                if(massLeft <= massRight){
                    controler = 0;
                }else{
                    controler = 1;
                }

                switch (controler) {
                    case 0:
                        massLeft += massContainer;
                        if (indexLeftCount <= 1000) {
                            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerLeft]) + String.valueOf(indexContainer);
                            indexLeftCount++;
                            indexContainer++;
                            bw.write(numberContainer + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massContainer) + "\t" + wares + "\n");
                        } else {
                            if(indexRowConitanerLeft > 0)
                                indexRowConitanerLeft--;
                            else
                                indexRowConitanerLeft++;

                            indexContainer++;
                            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerLeft]) + String.valueOf(indexContainer);
                            indexLeftCount++;
                            bw.write(numberContainer + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massContainer) + "\t" + wares + "\n");
                        }
                        break;
                    case 1:
                        massRight += massContainer;
                        if (indexLeftCount <= 1000) {
                            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerRight]) + String.valueOf(indexContainer);
                            indexRightCount++;
                            indexContainer++;
                            bw.write(numberContainer + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massContainer) + "\t" + wares + "\n");
                        } else {
                            if(indexRowConitanerRight < 14)
                                indexRowConitanerRight++;
                            else
                                indexRowConitanerRight--;

                            indexContainer++;
                            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerRight]) + String.valueOf(indexContainer);
                            indexRightCount++;
                            bw.write(numberContainer + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massContainer) + "\t" + wares + "\n");
                        }
                        break;
                    default:
                        break;
                }
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


 */


}
