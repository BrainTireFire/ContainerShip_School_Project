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
    private char[] rowContainerPlace = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'};
    private String idContainerPlace;
    private int indexContainer = 0;
    //Zmienne do dzialan
    private String[] arrayTemp;
    private String result = new String();
    private double massRight = 0;
    private int indexRightCount = 0;
    private int indexRowConitanerRight = 8;
    private double massLeft = 0;
    private int indexLeftCount =0;
    private int indexRowConitanerLeft = 6;

    public ContainerShip(String nameOfShip, double width, double height, double length, double maxMassCapacity){
        this.nameOfShip = nameOfShip;
        this.width = width;
        this.height = height;
        this.length = length;
        this.maxMassCapacity = maxMassCapacity;
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
        arrayTemp = new String[10];
        try {
            BufferedReader br = new BufferedReader(new FileReader("containerList.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Manifest.txt"));
            String line;
            while( (line = br.readLine()) != null){
               String[] vals = line.split(",");
                arrayTemp[0] = vals[0]; //NumberConitaner
                arrayTemp[1] = vals[1];
                arrayTemp[2] = vals[2];
                arrayTemp[3] = vals[3];
                arrayTemp[4] = vals[4]; //massContainer
                arrayTemp[5] = vals[5];
                arrayTemp[6] = vals[6];
                arrayTemp[7] = vals[7];
                arrayTemp[8] = vals[8];
                arrayTemp[9] = vals[9];
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

    // Right side of Container Ship
    public String containerRightSide(){
        double massTemp = Double.parseDouble(arrayTemp[4]);

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
        return result;
    }

    // Left side of Container Ship
    public String containerLeftSide(){
        double massTemp = Double.parseDouble(arrayTemp[4]);

        massLeft += massTemp;
        if (indexLeftCount <= 1000) {
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerLeft]) + String.valueOf(indexContainer);
            indexLeftCount++;
            indexContainer++;
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
        } else {
            if(indexRowConitanerLeft > 0)
                indexRowConitanerLeft--;
            else
                indexRowConitanerLeft++;

            indexContainer++;
            idContainerPlace = String.valueOf(rowContainerPlace[indexRowConitanerLeft]) + String.valueOf(indexContainer);
            indexLeftCount++;
            result = (arrayTemp[0] + "\t" + idContainerPlace + "\t" + roundTo2DecimalPlace(massTemp) + "\t" + arrayTemp[9] + "\n");
        }
        return result;
    }

    public double roundTo2DecimalPlace(double value) {
        return Math.round(value * 100) / 100;
    }

/*
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
