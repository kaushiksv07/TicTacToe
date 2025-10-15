package stratergy;

import models.Board;
import models.Cell;
import models.CellSatus;
import models.Player;

public class ColumnWinStratergy implements WinStratergy{

    @Override
    public boolean checkWinPossible(Board board, Player player, int row, int col) {
        for(int i=0;i<board.getSize();i++){
            Cell cell = board.getCells().get(i).get(col);
            if (cell.getCellSatus() == CellSatus.EMPTY
                    || cell.getPlayer() == null
                    || !cell.getPlayer().equals(player)) {
                return false;
            }
        }
        return true;
    }
}
