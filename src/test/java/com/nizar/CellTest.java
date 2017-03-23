package com.nizar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by nyassine on 22/03/2017.
 */
public class CellTest {

    //Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    @Test
    public void LiveCellWithZeroLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(0);

        assertEquals(CellState.DEAD, actual);
    }

    @Test
    public void LiveCellWithOneLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(1);

        assertEquals(CellState.DEAD, actual);
    }

    //Any live cell with more than three live neighbours dies, as if by overcrowding
    @Test
    public void LiveCellWithFourLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(4);

        assertEquals(CellState.DEAD, actual);
    }

    @Test
    public void LiveCellWithFiveLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(5);

        assertEquals(CellState.DEAD, actual);
    }

    @Test
    public void LiveCellWithSixLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(6);

        assertEquals(CellState.DEAD, actual);
    }

    @Test
    public void LiveCellWithSevenLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(7);

        assertEquals(CellState.DEAD, actual);
    }

    @Test
    public void LiveCellWithEightLiveNeighborsDies() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(8);

        assertEquals(CellState.DEAD, actual);
    }

    //Any live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void LiveCellWithTwoLiveNeighborsLives() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(2);

        assertEquals(CellState.ALIVE, actual);
    }

    @Test
    public void LiveCellWithThreeLiveNeighborsLives() {
        Cell cell = new Cell(CellState.ALIVE);

        CellState actual = cell.getNextGenerationState(3);

        assertEquals(CellState.ALIVE, actual);
    }

    //Any dead cell with exactly three live neighbours becomes a live cell.
    @Test
    public void DeadCellWithThreeLiveNeighborsLives() {
        Cell cell = new Cell(CellState.DEAD);

        CellState actual = cell.getNextGenerationState(3);

        assertEquals(CellState.ALIVE, actual);
    }
}