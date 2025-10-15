package service;

import models.Board;
import models.Player;
import models.Symbol;
import repository.BoardRepo;
import repository.PlayerRepo;

public class GameServiceImpl implements GameService {
    private final PlayerRepo playerRepo;
    private final BoardRepo boardRepo;
    public GameServiceImpl(PlayerRepo playerRepo, BoardRepo boardRepo) {
        this.playerRepo = playerRepo;
        this.boardRepo = boardRepo;
    }
    @Override
    public Player savePlayer(Symbol symbol) {
        return playerRepo.savePlayer(symbol);
    }

    @Override
    public Board saveBoard(int size) {
        return boardRepo.createBoard(size);
    }
}
