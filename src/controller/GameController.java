package controller;

import exceptions.CellAlreadyOccupiedException;
import exceptions.InvalidMoveException;
import models.*;
import service.BoardService;
import service.CellService;
import service.GameService;
import stratergy.WinStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Scanner sc = new Scanner(System.in);
    private BoardService boardService;
    private GameService gameService;
    private CellService cellService;
    private  Game game;
    List<Player> players = new ArrayList<>();
    Board board = new Board();
    int boardSize = 0;
    private List<WinStratergy> winStrategies;
    public GameController(BoardService boardService, GameService gameService, CellService cellService, List<WinStratergy> winStrategies) {
        this.boardService = boardService;
        this.gameService = gameService;
        this.cellService = cellService;
        this.winStrategies = winStrategies;
    }

    public Game startGame(){
        System.out.println("Please enter the number of player");
        int size = sc.nextInt();

        board =  gameService.saveBoard(size+1);
        board.setSize(size+1);

        List<List<Cell>> cells = new  ArrayList<>();
        for(int i = 0; i < board.getSize(); i++){
            List<Cell> rowCells = new ArrayList<>();
            for(int j = 0; j < board.getSize(); j++){
                Cell cell = new Cell(i, j);
                rowCells.add(cell);
            }
            cells.add(rowCells);
        }
        board.setCells(cells);
        boardSize =  board.getSize();
        System.out.println("Borad got created");
        for(int i = 0; i < size; i++){
            System.out.println("Please enete the player symbol");

            String string = sc.next();
            Symbol symbol = new  Symbol();
            symbol.setSymbol(string);
            Player player =  gameService.savePlayer(symbol);
            players.add(player);
        }

        game = new Game();
        game.setPlayers(players);
        game.setBoard(board);
        game.setGameSatus(GameSatus.INPROGRESS);
        game.setCurrentPlayerIdx(0);
        boardService.displayBoard(board);
        return  game;
    }

    public void movePlayer(){
        int curIdx = game.getCurrentPlayerIdx();
        System.out.println("Please enter the row number of" + players.get(curIdx).getSymbol().getSymbol());
        int row = sc.nextInt();
        System.out.println("Please enter the column of" + players.get(curIdx).getSymbol().getSymbol());
        int col = sc.nextInt();

        if(row >= boardSize || row < 0 || col >= boardSize || col < 0){
            throw new InvalidMoveException("Please enter the moves correctly");
        }

        CellSatus cellSatus = cellService.getCellDetails(row, col);

        if (cellSatus == CellSatus.OCCUPIED){
            throw new CellAlreadyOccupiedException("Cell already occupied please enter diffeent cell");
        }


        cellService.saveCellDetails(row, col, players.get(curIdx));

//        boardService.getBoard();
        boardService.displayBoard(board);

        for(WinStratergy winStratergy: winStrategies){
            if(winStratergy.checkWinPossible(board, game.getPlayers().get(curIdx), row, col)){
                game.setGameSatus(GameSatus.WIN);
                return;
            }
        }

        curIdx = (curIdx + 1) % players.size();
        game.setCurrentPlayerIdx(curIdx);


    }
    public GameSatus getGameStatus(){
        return  game.getGameSatus();
    }
}
