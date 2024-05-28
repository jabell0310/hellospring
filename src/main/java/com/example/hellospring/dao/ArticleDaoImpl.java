package com.example.hellospring.dao;

import com.example.hellospring.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    private static final String INSERT_ARTICLE_QUERY = "INSERT INTO ARTICLE(id,author_id,board_id,title,content,created_date,modified_date) values (?,?,?,?,?,?,?)";

    private static final String GET_ARTICLES_QUERY = "SELECT * FROM ARTICLE";
    private static final String GET_ARTICLE_BY_ID_QUERY = "SELECT * FROM ARTICLE WHERE ID=?";

    private static final String GET_ARTICLES_BY_BOARD_ID = "SELECT * FROM ARTICLE WHERE board_id=?";

    private static final String UPDATE_ARTICLES_BY_ID_QUERY = "UPDATE ARTICLE SET board_id = ?, content=?, title=? WHERE ID=?";

    private static final String DELETE_ARTICLE_BY_ID = "DELETE FROM ARTICLE WHERE ID=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createArticle(Article article) {
        jdbcTemplate.update(INSERT_ARTICLE_QUERY,article.getId(),article.getAuthor_id(),article.getBoard_id(),article.getTitle(),article.getContent(),article.getCreated_date(),article.getModified_date());
    }


    @Override
    public List<Article> allArticles() {
        return jdbcTemplate.query(GET_ARTICLES_QUERY,(rs, rowNum) -> new Article(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("board_id"), rs.getString("title"), rs.getString("content"), rs.getTimestamp("created_date"), rs.getTimestamp("modified_date")));
    }


    @Override
    public List<Article> allBoardArticles(int board_id) {
        return jdbcTemplate.query(GET_ARTICLES_BY_BOARD_ID,(rs, rowNum) -> new Article(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("board_id"), rs.getString("title"), rs.getString("content"), rs.getTimestamp("created_date"), rs.getTimestamp("modified_date")), board_id);
    }


    @Override
    public Article getById(int id) {
        return jdbcTemplate.queryForObject(GET_ARTICLE_BY_ID_QUERY,(rs, rowNum) -> new Article(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("board_id"), rs.getString("title"), rs.getString("content"), rs.getTimestamp("created_date"), rs.getTimestamp("modified_date")),id);
    }


    @Override
    public Article updateArticle(Article article, String id) {
        jdbcTemplate.update(UPDATE_ARTICLES_BY_ID_QUERY, article.getBoard_id(), article.getContent(), article.getTitle(),Integer.parseInt(id));
        return article;
    }


    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_ARTICLE_BY_ID,id);
    }


}
