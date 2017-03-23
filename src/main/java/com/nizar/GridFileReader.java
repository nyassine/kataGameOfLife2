package com.nizar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by nyassine on 23/03/2017.
 */
public class GridFileReader {

    //TO DO: En cours
//    public static Grid read(String fileName)throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        String str = reader.readLine();
//        System.out.println("dimension line start");
//        for (char c : str.toCharArray()){
//            if (Character.isDigit(c)) {
//                System.out.println("dimension " + c + " detected");
//            }
//        }
//        while ((str = reader.readLine()) != null){
//            System.out.println("line start");
//            for (char c : str.toCharArray()){
//                if (c == '*'){
//                    System.out.println("X detected");
//                }
//                if (c == '.'){
//                    System.out.println("O detected");
//                }
//            }
//        }
//
//
//
//
//        Grid grid = new Grid();
//        return grid;
//    }
}
