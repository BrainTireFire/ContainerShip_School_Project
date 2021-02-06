package com.company.p2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Node {

    Node next;
    Object val;

    public Node(Object val){
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext(){
        return next;
    }

    @Override
    public String toString() {
        return  "" + val;
    }
}
