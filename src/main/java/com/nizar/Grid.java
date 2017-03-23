package com.nizar;

/**
 * Created by nyassine on 22/03/2017.
 */
public class Grid {

    private Cell[][] gridCells;

    public Grid(CellState[][] gridCellStates) {
        gridCells = new Cell[gridCellStates.length][gridCellStates[0].length];
        for (int row = 0; row < gridCellStates.length; row++) {
            for (int col = 0; col < gridCellStates[row].length; col++) {
                gridCells[row][col] = new Cell(gridCellStates[row][col]);
            }
        }
    }

    public Grid(int row, int column) {
        gridCells = new Cell[row][column];
    }

    public Grid() {

    }

    public CellState[][] getStatePattern() {
        CellState[][] gridCellStates = new CellState[gridCells.length][gridCells[0].length];

        for (int row = 0; row < gridCells.length; row++) {
            for (int col = 0; col < gridCells[row].length; col++) {
                gridCellStates[row][col] = gridCells[row][col].getCellState();
            }
        }

        return gridCellStates;
    }

    public Cell[][] getGridCells() {
        return gridCells;
    }

    public Grid getNextGrid() {
        Grid nextGrid = new Grid(gridCells.length, gridCells[0].length);
        for (int row = 0; row < gridCells.length; row++) {
            for (int col = 0; col < gridCells[row].length; col++) {
                int neighborNumber = getNeighborNumber(row, col);
                nextGrid.gridCells[row][col] = gridCells[row][col].getNextGenerationCell(neighborNumber);
            }
        }

        return nextGrid;
    }

    public int getNeighborNumber(int cellRow, int cellCol) {
        int neighborNumber = 0;

        for (int row = (cellRow != 0) ? cellRow - 1 : 0; row <= ((cellRow != gridCells.length - 1) ? (cellRow + 1) : gridCells.length - 1); row++) {
            for (int col = (cellCol != 0) ? cellCol - 1 : 0; col <= ((cellCol != gridCells[row].length - 1) ? (cellCol + 1) : gridCells[row].length - 1); col++) {
                if (!(row == cellRow && col == cellCol) & gridCells[row][col].getCellState() == CellState.ALIVE) {
                    neighborNumber++;
                }
            }
        }

        return neighborNumber;
    }

    public void print() {
        CellState[][] pattern = getStatePattern();
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length; j++) {
                System.out.print(((pattern[i][j] == CellState.ALIVE) ? "*" : ".") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public int getRows() {
        return gridCells.length;
    }

    public int getCols() {
        return gridCells[0].length;
    }
}
