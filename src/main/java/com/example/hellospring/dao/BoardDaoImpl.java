package com.example.hellospring.dao;

import com.example.hellospring.model.Article;
import com.example.hellospring.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {

    private static final String INSERT_BOARD_QUERY = "INSERT INTO BOARD(id,name) values (?,?)";
    private static final String GET_BOARDS_QUERY = "SELECT * FROM BOARD";
    private static final String GET_BOARD_BY_ID_QUERY = "SELECT * FROM BOARD WHERE ID=?";
    private static final String UPDATE_BOARDS_BY_ID_QUERY = "UPDATE BOARD SET name=? WHERE ID=?";
    private static final String DELETE_BOARD_BY_ID = "DELETE FROM BOARD WHERE ID=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createBoard(Board board) {
        jdbcTemplate.update(INSERT_BOARD_QUERY,board.getId(),board.getTitle());
    }

    @Override
    public List<Board> allBoards() {
        return  jdbcTemplate.query(GET_BOARDS_QUERY, (rs, rowNum) -> {
            return new Board(rs.getInt("id"),rs.getString("name"));
        });
    }

    @Override
    public Board getById(int id) {
        return jdbcTemplate.queryForObject(GET_BOARD_BY_ID_QUERY, (rs, rowNum) -> {
            return new Board(rs.getInt("id"),rs.getString("name"));
        }, id);
    }

    @Override
    public Board updateTitle(Board board) {
        jdbcTemplate.update(UPDATE_BOARDS_BY_ID_QUERY,board.getTitle(),board.getId());
        return board;
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_BOARD_BY_ID,id);
    }
}
