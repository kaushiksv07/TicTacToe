package models;

public class Cell {
    private Player player;
    private CellSatus cellSatus;
    private int row;
    private int column;

    public Cell(int row, int col){
        this.row = row;
        this.column = col;
    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellSatus getCellSatus() {
        return cellSatus;
    }

    public void setCellSatus(CellSatus cellSatus) {
        this.cellSatus = cellSatus;
    }

    void displayCell(){
        if(cellSatus == CellSatus.EMPTY){
            System.out.print("| - |");
        }else if(cellSatus == CellSatus.OCCUPIED){
            System.out.print("| " + player.getSymbol() + " |");
        }
    }
}
