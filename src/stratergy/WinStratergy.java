package stratergy;

import models.Board;
import models.Player;

public interface WinStratergy {
    boolean checkWinPossible(Board board, Player player);
}
