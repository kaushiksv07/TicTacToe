package stratergy;

import models.Board;
import models.Player;

public class RowWinStratergy implements WinStratergy{
    @Override
    public boolean checkWinPossible(Board board, Player player) {
        return false;
    }
}
