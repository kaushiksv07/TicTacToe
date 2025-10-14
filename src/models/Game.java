package models;


import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private GameSatus gameSatus;
    private int currentPlayerIdx;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameSatus getGameSatus() {
        return gameSatus;
    }

    public void setGameSatus(GameSatus gameSatus) {
        this.gameSatus = gameSatus;
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public void setCurrentPlayerIdx(int currentPlayerIdx) {
        this.currentPlayerIdx = currentPlayerIdx;
    }


}
