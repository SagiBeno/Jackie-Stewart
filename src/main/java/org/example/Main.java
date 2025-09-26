package org.example;

import java.io.IOException;

public class Main {
    private static void debugger() {}

    public static void main(String[] args) throws IOException {
        // 1. feladat: Jackie
        // 2. feladat
        JackieService service = new JackieService("files/jackie.txt");

        // 3. feladat
        System.out.println("3. feladat: " + service.getLinesLenght()); // 10

        // 4. feladat
        System.out.println("4. feladat: " + service.countRaces());

        // 5. feladat
        System.out.println("5. feladat: " + service.nyeresekEvtizedenkent());

        // 6. feladat
        service.htmlIras("files/jackie.html");
        System.out.println("6. feladat: jackie.html");
        debugger();
    }
}