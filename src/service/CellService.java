package service;

import models.Cell;
import models.CellSatus;
import models.Player;

public interface CellService {
    CellSatus getCellDetails(int row, int col);
    Cell saveCellDetails(int row, int col, Player player);
}
