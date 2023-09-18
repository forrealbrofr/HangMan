package org.example;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String word = "isolation";
        int index = word.indexOf('i');
        System.out.println(index);
        System.out.println(word.indexOf('i', index+1));
    }
}