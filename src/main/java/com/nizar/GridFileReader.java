package com.nizar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nyassine on 23/03/2017.
 */
public class GridFileReader {

    public static Grid readFromFile(String fileName)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str = reader.readLine();
        int dimensionCount = 1;
        int row = 0;
        int col = 0;
        int charIndex = 0;
        //char[] dimension = new char[3];
        String dimension = "";
        for (char c : str.toCharArray()){

            if (Character.isDigit(c)) {
                dimension+= c;
                charIndex++;
            }
            else{
                if (dimensionCount == 1 && charIndex > 0){
                    System.out.println(Integer.parseInt(dimension));
                    row = Integer.parseInt(dimension);
                    dimensionCount++;
                    charIndex = 0;
                    dimension = "";
                }
                if (dimensionCount == 2 && charIndex > 0){
                    System.out.println(Integer.parseInt(dimension));
                    col = Integer.parseInt(dimension);
                    break;
                }
            }
        }
        if (charIndex > 0){
            System.out.println(Integer.parseInt(dimension));
            col = Integer.parseInt(dimension);
        }
        Grid inputGrid = new Grid(row,col);
        int rowIndex = 0;

        while ((str = reader.readLine()) != null){
            System.out.println("new line");
            int colIndex = 0;
            for (char c : str.toCharArray()){
                if (c == '*'){
                    System.out.println("* detected");
                    inputGrid.getGridCells()[rowIndex][colIndex] = new Cell(CellState.ALIVE);
                    colIndex++;
                }
                if (c == '.'){
                    System.out.println(". detected");
                    inputGrid.getGridCells()[rowIndex][colIndex] = new Cell(CellState.DEAD);
                    colIndex++;
                }
            }
            rowIndex++;
        }
        return inputGrid;
    }
}
