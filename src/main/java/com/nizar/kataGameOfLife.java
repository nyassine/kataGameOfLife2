package com.nizar;

/**
 * Hello world!
 *
 */
public class kataGameOfLife
{

    public static void main( String[] args )
    {
        final CellState X = CellState.ALIVE;
        final CellState O = CellState.DEAD;

        Grid grid = new Grid(new CellState[][]{
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, X, O, X, O, X, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, X, O, O, O, X, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, X, O, O, O, X, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, X, O, O, O, X, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, X, O, X, O, X, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },
                { O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O },

        });

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
