package repository;

import models.Board;

public interface BoardRepo {
    Board createBoard(int size);
}
