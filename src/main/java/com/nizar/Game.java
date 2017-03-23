package com.nizar;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by nyassine on 23/03/2017.
 */
public class Game {
    public static void run() throws IOException {
        //asks file location
        System.out.println("Enter file location (if nothing is typed and you press enter, glider example will start)");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        if (filename.equals("")){
            filename = "glider.txt";
        }

        //creates grid and prints
        Grid grid = GridFileReader.readFromFile(filename);
        grid.print();

        //plays next move at every "enter"
        System.out.println("press enter for next generation, s to stop");
        if (scanner.hasNextLine()){
            while (!scanner.nextLine().equals("s")){
                grid = grid.getNextGrid();
                grid.print();
            }

        }
    }

    public void animateGlider() throws IOException {

        Grid grid = GridFileReader.readFromFile("glider.txt");

        grid.print();
        for (int i = 0; i<200; i++){
            try
            {
                Thread.sleep(100);//1sec
                grid = grid.getNextGrid();
                grid.print();

            }
            catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }

    }
}
