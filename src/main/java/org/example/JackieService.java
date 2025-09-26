package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        setMatrix(new int[countLines][6]);
        // read from file to matrix
        readFromFile(filename);
    }

    private int countLines(String filename) throws FileNotFoundException {
        File fbe = new File(filename);
        Scanner scanner = new Scanner(fbe);
        scanner.nextLine();
        int result = 0; // vagy result = 0-1
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            result++;
        }
        return result;
    }

    private void readFromFile(String filename) throws FileNotFoundException {
        File fbe = new File(filename);
        Scanner scanner = new Scanner(fbe);
        scanner.nextLine();
        int index = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split("\t");

            for (int i = 0; i < 6; i++) {
                matrix[index][i] = Integer.parseInt(split[i]);
            }
            index++;
        }
        scanner.close();
    }

    public int getLinesLenght() {
        return getMatrix().length;
    }

    public int countRaces() {
        List<Integer> races = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            races.add(matrix[i][1]);
        }
        int max = Collections.max(races);
        int index = races.indexOf(max);
        int evszam = matrix[index][0];
        return evszam;
    }

    public StringBuilder nyeresekEvtizedenkent () {
        List<Integer> evtizedek = new ArrayList<>();

        for (int i = 0; i < getMatrix().length; i++) {
            if (!evtizedek.contains(getMatrix()[i][0] % 1000 % 100 / 10)) {
                evtizedek.add(getMatrix()[i][0] % 1000 % 100 / 10);
            }

        }

        Collections.sort(evtizedek);
        int[] gyozelemSzamok = new int[evtizedek.size()];
        for (int i = 0; i < evtizedek.size(); i++) {

            for (int j = 0; j < getMatrix().length; j++) {
                int evszamUtolsoKetto = getMatrix()[j][0] % 1000 % 100 / 10;

                if (evszamUtolsoKetto == evtizedek.get(i)) {
                    gyozelemSzamok[i] += getMatrix()[j][2];
                }
            }
        }

        StringBuilder kiiras = new StringBuilder();
        for (int i = 0; i < evtizedek.size(); i++) {
            kiiras.append("\n   ");
            kiiras.append(evtizedek.get(i));
            kiiras.append("0-as/es évek: ");
            kiiras.append(gyozelemSzamok[i]);
            kiiras.append(" megnyeret verseny");
        }

        return kiiras;
    }

    public void htmlIras(String filename) throws IOException {
        File fki = new File(filename);
        FileWriter writer = new FileWriter(fki);
        StringBuilder html = new StringBuilder();
        html.append(
                "<!doctype html>\n" +
                "<html>\n" +
                "<head></head>\n" +
                "<style>\nth, td { border: 1px solid black; padding: 5px; } \n table { border-collapse: collapse; text-align: center; }</style>\n" +
                "<body>\n" +
                "<h1>Jackie Stewart</h1>\n" +
                "<table>\n" +
                "<tr><th>Versenyzés éve</th><th>Versenyek száma</th><th>Győzelmek száma</th></tr>\n"
        );

        for (int i = 0; i < getMatrix().length; i++) {
            html.append(
                    "<tr><td>" + getMatrix()[i][0] + "</td><td>" + getMatrix()[i][1] + "</td><td>" + getMatrix()[i][2] + "</td></tr>\n"
            );
        }

        html.append(
                "</table>\n" +
                "</body>\n" +
                "</html>\n"
        );

        writer.write(String.valueOf(html));
        writer.close();
    }
}
