package com.example.hellospring.repository;



import com.example.hellospring.model.Board;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public class BoardRepository {
    static public ArrayList<Board> boards;

    static {
        boards = new ArrayList<>();
        boards.add(new Board(1,"Game of 2019"));
        boards.add(new Board(2,"Game of 2020"));
        boards.add(new Board(3,"Game of 2021"));
        boards.add(new Board(4,"Game of 2022"));
        boards.add(new Board(5,"Game of 2023"));
    }

    public Board create(Board board) {
        boards.add(board);
        return board;
    }

    public ArrayList<Board> findAll() {
        return boards;
    }

    public Board findById(String id) {
        return boards.stream()
                .filter(Board -> Board.getId().equals(Integer.parseInt(id)))
                .findAny()
                .orElse(new Board(null, ""));
    }

    public void updateTitle(String id, String title) {
        boards.stream()
                .filter(Community -> Community.getId().equals(Integer.parseInt(id)))
                .findAny()
                .orElse(new Board(null, ""))
                .setTitle(title);

    }

    public void delete(String id) {
        boards.removeIf(Board -> Board.getId().equals(Integer.parseInt(id)));
    }
}
