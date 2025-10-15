package service;

import models.Board;
import models.Player;
import models.Symbol;

public interface GameService {
    Player savePlayer(Symbol symbol);
    Board saveBoard(int size);
}
