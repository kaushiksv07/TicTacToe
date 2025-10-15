package repository;

import models.Player;
import models.Symbol;

public interface PlayerRepo {
    Player savePlayer(Symbol symbol);
}
