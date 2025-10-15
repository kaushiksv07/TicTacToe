package service;

import models.Board;
import models.Cell;
import models.CellSatus;
import models.Player;
import repository.CellRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardServiceImpl implements BoardService {
    private final CellRepo cellRepo;

    public BoardServiceImpl(CellRepo cellRepo) {
        this.cellRepo = cellRepo;
    }

    @Override
    public void displayBoard(Board board) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                CellSatus cellSatus = cellRepo.getCellDetails(i, j);
                if(cellSatus == CellSatus.EMPTY) {
                        System.out.print("| - |");
                }else{
                    Optional<Player> player = cellRepo.getPlayerDetails(i, j);
                    if(player.isPresent()) {
                        System.out.print("| " + player.get().getSymbol().getSymbol()  + " |");
                    }
                }
            }
            System.out.println();
        }
    }

    @Override
    public Board getBoard(int boardSize) {
        List<List<Cell>> cells = new ArrayList<>();
        for(int i = 0; i < boardSize; i++) {
            List<Cell> rowList = new ArrayList<>();
            for(int j = 0; j < boardSize; j++) {
                Cell cell = cellRepo.getCellData(i, j);
                rowList.add(cell);
            }
            cells.add(rowList);
        }
        Board board = new Board();
        board.setCells(cells);
        board.setSize(boardSize);
        return board;
    }
}
