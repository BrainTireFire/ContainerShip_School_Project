package com.company;

import com.company.p1.*;
import com.company.p2.MyList;
import com.company.p2.Node;
import com.company.p3.ContainerShip;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class S20202 {

    public static void main(String[] args) {

        String[] waresEatable = {"Banany", "Pomarancze", "Kokosy", "Ananasy"};
        String[] waresTank = {"Woda", "Sok", "Rteć", "Azot"};
        String[] waresStandart = {"Buty", "Sprzęt Muzyczny", "Beczki", "RTV", "Zabawki", "Czajniki", "Meble", "Zapalniczki", "Drewno", "Piłki"};
        String[] waresBig = {"Motory", "Podnośnik", "Wózek", "Betoniarka"};
        String[] waresVeryBig = {"Traktor", "Przyczepa", "Tir", "Walec"};

        MyList myList = new MyList();
        double j = 1; //Indefikator Kontenera
        for(int i=0;i<2500;i++) {
            myList.add(new StandartContainer(j,235, 239, 1200, Math.random()* 30000 + 5000, 230, 227, 28500, 67.3, waresStandart[(int)(Math.random()*10-1)]));
            j++;
            myList.add(new ContainerHighCube(j,235, 270, 1200, Math.random()* 30000 + 5000, 230, 260, 28500, 76.3, waresStandart[(int)(Math.random()*10-1)]));
            j++;
            myList.add(new ContainerReefer(Math.random()*60 - 120, j,235, 239, 1156, Math.random()* 3500 + 5000, 230, 260, 28500, 76.3, waresEatable[(int)(Math.random()*4-1)]));
            j++;
            myList.add(new ContainerTank(Math.random()*50 - 75, j,235, 239, 1200, Math.random()* 3500 + 5000, 230, 260, 28500, 26, waresTank[(int)(Math.random()*4-1)]));
            j++;
            myList.add(new ContainerOpenTop(j,235, 270, 1200, Math.random()* 30000 + 5000, 230, 260, 28500, 76.3, waresBig[(int)(Math.random()*4-1)], "roofOpen"));
            j++;
            myList.add(new ContainerPlatforma(j,235, 0, 1200, Math.random()* 3500 + 5000, 0, 0, 42000, 0, waresVeryBig[(int)(Math.random()*4-1)], "all"));
            j++;
        }
        myList.addToFile();

        ContainerShip containerShip = new ContainerShip("Hercules Tytanus", 90, 20, 500, 23769);
        containerShip.createManifest();



    }
}



