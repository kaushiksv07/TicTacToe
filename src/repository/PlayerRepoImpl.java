package repository;

import models.Player;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepoImpl implements PlayerRepo {
    private int counter = 1;
    private Map<Integer, Player> players = new HashMap<>();
    @Override
    public Player savePlayer(Symbol symbol) {
        Player player = new Player();
        player.setSymbol(symbol);
        player.setId(counter++);
        players.put(player.getId(), player);
        return player;
    }
}
