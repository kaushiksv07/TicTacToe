package client;

import controller.GameController;
import exceptions.CellAlreadyOccupiedException;
import exceptions.InvalidMoveException;
import models.GameSatus;
import repository.BoardRepoImpl;
import repository.CellRepoImpl;
import repository.PlayerRepo;
import repository.PlayerRepoImpl;
import service.*;
import stratergy.ColumnWinStratergy;
import stratergy.DiagnolWinStratergy;
import stratergy.RowWinStratergy;
import stratergy.WinStratergy;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeClient {

    public static void main(String[] args) {

        CellRepoImpl cellRepo = new CellRepoImpl();
        PlayerRepo playerRepo = new PlayerRepoImpl();
        BoardRepoImpl boardRepo = new BoardRepoImpl();

        BoardService boardService = new BoardServiceImpl(cellRepo);
        GameService gameService = new GameServiceImpl(playerRepo, boardRepo);
        CellService cellService = new CellServiceImpl(cellRepo);

        List<WinStratergy> winStrategies = new ArrayList<>();
        winStrategies.add(new RowWinStratergy());
        winStrategies.add(new ColumnWinStratergy());
        winStrategies.add(new DiagnolWinStratergy());


        GameController gameController = new GameController(boardService, gameService, cellService, winStrategies);
        //Start the game
        gameController.startGame();


        //move
        GameSatus gameSatus =  gameController.getGameStatus();
        while (gameSatus.equals(GameSatus.INPROGRESS)) {
            try {
                gameController.movePlayer();
            } catch (InvalidMoveException | CellAlreadyOccupiedException e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }
    }
}
