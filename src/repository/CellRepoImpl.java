package repository;

import models.Cell;
import models.CellSatus;
import models.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CellRepoImpl implements CellRepo {
    private int id=1;
    private Map<Integer,Cell> cellMap = new HashMap<>();

    @Override
    public Cell saveCell(int row, int col, Player player) {
        Cell cellDts = new Cell(row, col);
        cellDts.setPlayer(player);
        cellDts.setCellSatus(CellSatus.OCCUPIED);
        cellMap.put(id++, cellDts);
        return cellDts;
    }

    @Override
    public CellSatus getCellDetails(int row, int col) {
        for(Cell cell:cellMap.values()){
            if(cell.getRow() == row && cell.getColumn() == col){
                return cell.getCellSatus();
            }
        }
        return CellSatus.EMPTY;
    }

    @Override
    public Cell getCellData(int row, int col) {
        for(Cell cell:cellMap.values()){
            if(cell.getRow() == row && cell.getColumn() == col){
                return cell;
            }
        }
        return null;
    }

    @Override
    public Optional<Player> getPlayerDetails(int row, int col) {
        for(Cell cell:cellMap.values()){
            if(cell.getRow() == row && cell.getColumn() == col){
                return Optional.ofNullable(cell.getPlayer());
            }
        }
        return  null;
    }
}
