package com.company.p2;

import com.company.p1.StandartContainer;

import java.io.*;
import java.util.Scanner;

public class MyList {

    Node head;

    public MyList(){
        head = null;
    }

    public void add(Object val){
        Node tmp = new Node(val);
        if(head == null) {
            head = tmp;
        } else{
            Node headDublicate = head;
            while(headDublicate.getNext() != null){
                headDublicate = headDublicate.getNext();
            }
            headDublicate.setNext(tmp);
        }
    }

    public void show(){
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.toString());
            tmp = tmp.getNext();
        }
    }

    public void addToFile(){
        Node tmp = head;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("containerList.txt"));
            while(tmp != null) {
                bw.write(tmp + "\n");
                tmp = tmp.getNext();
            }
            bw.flush();
            bw.close();
            System.out.println("Plik został poprawnie stworzony, a kontenery dodane.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
