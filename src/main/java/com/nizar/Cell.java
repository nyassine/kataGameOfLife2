package com.nizar;

/**
 * Created by nyassine on 22/03/2017.
 */
public class Cell {

    private CellState cellState;

    public Cell(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getNextGenerationState(int neighborNumber) {
        return getNextGenerationCell(neighborNumber).getCellState();

    }

    public CellState getCellState() {
        return cellState;
    }

    public Cell getNextGenerationCell(int neighborNumber) {
        Cell nextCell;

        if (neighborNumber != 2 && neighborNumber != 3 && cellState == CellState.ALIVE) {
            nextCell = new Cell(CellState.DEAD);
        } else if (neighborNumber == 3) {
            nextCell = new Cell(CellState.ALIVE);
        } else {
            nextCell = new Cell(cellState);
        }

        return nextCell;
    }
}
