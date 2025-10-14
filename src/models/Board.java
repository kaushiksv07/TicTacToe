package models;

import java.util.List;

public class Board {
    private int size;
    private List<Cell> cells;

    public void displayBoard(){
        for(int i = 0; i < size+1; i++){
            for(int j = 0; j < size+1; j++){
                Cell cell = new Cell(i, j);
                cell.displayCell();
            }
        }
    }
}
