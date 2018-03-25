package persistent.daos.postgres;

import business_logic.Article;
import persistent.daos.ArticleDAO;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public class ArticleDAOPostgres extends ArticleDAO {


    public ArticleDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Article article) {
        return false;
    }

    @Override
    public boolean delete(Article article) {
        return false;
    }

    @Override
    public ResultSet select(String articleId) {
        return null;
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }

    @Override
    public boolean update(String articleId, String descprtion, int quantity) {
        return false;
    }
}