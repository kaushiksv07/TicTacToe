package repository;

import models.Board;

import java.util.HashMap;
import java.util.Map;

public class BoardRepoImpl implements BoardRepo {

    private Map<Integer, Board> boardMap = new HashMap<>();
    private int id = 1;

    @Override
    public Board createBoard(int size) {
        Board board = new Board();
        board.setSize(size);
        boardMap.put(id++, board);
        return board;
    }
}
