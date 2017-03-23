package com.nizar;


import java.io.IOException;

public class kataGameOfLife
{

    public static void main( String[] args ) throws IOException {
        final CellState X = CellState.ALIVE;
        final CellState O = CellState.DEAD;

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
