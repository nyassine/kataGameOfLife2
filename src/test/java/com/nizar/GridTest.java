package com.nizar;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by nyassine on 22/03/2017.
 */
public class GridTest {

    public static final CellState X = CellState.ALIVE;
    public static final CellState O = CellState.DEAD;


    //Grid should return number of neighbors
    @Test
    public void gridShouldReturnNoNeighborsInOneCellGrid() {
        CellState[][] initialStatePattern = new CellState[][]{
                {X}
        };

        Grid grid = new Grid(initialStatePattern);

        assertEquals(0, grid.getNeighborNumber(0, 0));
    }

    @Test
    public void gridShouldReturnNumberOfNeighborsIfInsideGrid() {

        CellState[][] initialStatePattern = new CellState[][]{
                {X, O, O},
                {O, O, X},
                {O, O, X}
        };
        Grid grid = new Grid(initialStatePattern);

        assertEquals(3, grid.getNeighborNumber(1, 1));
    }

    @Test
    public void gridShouldReturnNumberOfNeighborsInBorder() {
        CellState[][] initialStatePattern = new CellState[][]{
                {X, O},
                {O, X},
                {O, X}
        };

        Grid grid = new Grid(initialStatePattern);

        assertEquals(2, grid.getNeighborNumber(0, 1));
    }

    //Cell grids should update
    @Test
    public void OneCellGridShouldUpdateCellInNextGrid() {
        Grid grid = new Grid(new CellState[][]{{X}});

        Grid nextGrid = grid.getNextGrid();

        assertEquals(O, nextGrid.getGridCells()[0][0].getCellState());
    }

    //Multi dimensional grid should update all cells
    @Test
    public void MultiDimensionalGridShouldUpdateAllCells() {
        CellState[][] initialStatePattern = new CellState[][]{
                {X, O, O},
                {O, X, X},
                {X, X, O}
        };
        Grid grid = new Grid(initialStatePattern);

        Grid nextGrid = grid.getNextGrid();

        assertArrayEquals(new CellState[][]{
                {O, X, O},
                {O, O, X},
                {X, X, X}
        }, nextGrid.getStatePattern());
    }

}