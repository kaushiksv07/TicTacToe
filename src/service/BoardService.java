package service;

import models.Board;

public interface BoardService {
    void displayBoard(Board board);
    Board getBoard(int boardSize);
}
