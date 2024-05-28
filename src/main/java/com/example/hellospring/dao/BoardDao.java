package com.example.hellospring.dao;

import com.example.hellospring.model.Board;

import java.util.List;

public interface BoardDao {
    public void createBoard(Board board);

    public List<Board> allBoards();

    public Board getById(int id);

    public Board updateTitle(Board board);

    public void deleteById(int id);
}
