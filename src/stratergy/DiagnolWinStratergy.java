package stratergy;

import models.Board;
import models.Cell;
import models.CellSatus;
import models.Player;

public class DiagnolWinStratergy implements WinStratergy{

    @Override
    public boolean checkWinPossible(Board board, Player player, int row, int col) {
        int size = board.getSize();

        boolean mainDiagonalWin = true;
        boolean antiDiagonalWin = true;

        // ✅ Check only if move lies on main diagonal
        if (row == col) {
            for (int i = 0; i < size; i++) {
                Cell cell = board.getCells().get(i).get(i);

                if (cell.getCellSatus() == CellSatus.EMPTY || !cell.getPlayer().equals(player)) {
                    mainDiagonalWin = false;
                    break;
                }
            }
        } else {
            mainDiagonalWin = false;
        }

        // ✅ Check only if move lies on anti-diagonal
        if (row + col == size - 1) {
            for (int i = 0; i < size; i++) {
                Cell cell = board.getCells().get(i).get(size - i - 1);

                if (cell.getCellSatus() == CellSatus.EMPTY || !cell.getPlayer().equals(player)) {
                    antiDiagonalWin = false;
                    break;
                }
            }
        } else {
            antiDiagonalWin = false;
        }

        return mainDiagonalWin || antiDiagonalWin;
    }
}
