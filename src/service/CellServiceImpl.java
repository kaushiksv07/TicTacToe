package service;

import models.Cell;
import models.CellSatus;
import models.Player;
import repository.CellRepo;

public class CellServiceImpl implements CellService{

    private CellRepo cellRepo;


    public CellServiceImpl(CellRepo cellRepo){
        this.cellRepo = cellRepo;
    }

    @Override
    public CellSatus getCellDetails(int row, int col) {
        return cellRepo.getCellDetails(row, col);
    }

    @Override
    public Cell saveCellDetails(int row, int col, Player player) {
        return cellRepo.saveCell(row, col, player);
    }
}
