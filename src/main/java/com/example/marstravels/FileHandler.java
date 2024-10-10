package com.example.marstravels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    public ArrayList<String> read( String path ) {
        ArrayList<String> DB = new ArrayList<>();
        try {
            File myObj = new File( path );
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                DB.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return DB;
    }

    public void write(String product, String path) {
        try {
            Files.write(Paths.get(path), (product + "\n").getBytes(), StandardOpenOption.APPEND); //lägg denna i file.java
        } catch (IOException e) {
            //för framtid exceptions
        }
    }

    /**
     * Läser av priserna, bara test @Axel
     * @return ArrayList med priser
     */
    public ArrayList<String> readPrices () {
        ArrayList<String> prices = new ArrayList<>();
        try {
            String path = "src/main/java/com/example/marstravels/prices.txt";
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                prices.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return prices;
    }
}
