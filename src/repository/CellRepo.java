package repository;

import models.Cell;
import models.CellSatus;
import models.Player;

import java.util.Optional;

public interface CellRepo {
    Cell saveCell(int row, int col, Player player);
    CellSatus getCellDetails(int row, int col);
    Cell getCellData(int row, int col);
    Optional<Player> getPlayerDetails(int row, int col);
}
