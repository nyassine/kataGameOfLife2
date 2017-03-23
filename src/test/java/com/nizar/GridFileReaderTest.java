package com.nizar;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by nyassine on 23/03/2017.
 */
public class GridFileReaderTest {

    public static final CellState X = CellState.ALIVE;
    public static final CellState O = CellState.DEAD;

    //Reader can read dimensions
    @Test
    public void readerShouldCreateGridWithRightDimensions() throws IOException {
        Grid grid = GridFileReader.readFromFile("file.txt");

        assertEquals(2, grid.getRows());
        assertEquals(4, grid.getCols());
    }

    //Reader can fill grid
    @Test
    public void readerFillsGridCreated() throws IOException {
        Grid grid = GridFileReader.readFromFile("file.txt");

        assertArrayEquals(new CellState[][]{
                {O, X, O, X},
                {X, O, O, O}
        }, grid.getStatePattern());
    }

}