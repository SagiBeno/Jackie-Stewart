package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JackieService {
    private int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public JackieService() {
        setMatrix(new int[1][1]);
    }

    public JackieService(String filename) throws FileNotFoundException {
        // count lines
        int countLines = countLines(filename);
        // init matrix
        // read from file to matrix
    }

    private int countLines(String filename) throws FileNotFoundException {
        File fbe = new File(filename);
        Scanner scanner = new Scanner(fbe);
        int result = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            result++;
        }
        return result;
    }
}
