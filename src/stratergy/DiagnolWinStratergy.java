package stratergy;

import models.Board;
import models.Player;

public class DiagnolWinStratergy implements WinStratergy{
    @Override
    public boolean checkWinPossible(Board board, Player player) {
        return false;
    }
}
