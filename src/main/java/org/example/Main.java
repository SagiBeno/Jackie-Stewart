package org.example;

import java.io.FileNotFoundException;

public class Main {
    private static void debugger() {}

    public static void main(String[] args) throws FileNotFoundException {
        // 1. feladat: Jackie
        // 2. feladat
        JackieService service = new JackieService("files/jackie.txt");

        // 3. feladat
        System.out.println("3. feladat: " + service.getLinesLenght()); // 10

        // 4. feladat
        System.out.println("4. feladat: " + service.countRaces());
        debugger();
    }
}