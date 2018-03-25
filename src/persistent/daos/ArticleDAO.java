package persistent.daos;

import business_logic.Article;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public abstract class ArticleDAO extends DAO {


    public ArticleDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param article 
     * @return
     */
    public abstract boolean insert(Article article);

    /**
     * @param article 
     * @return
     */
    public abstract boolean delete(Article article);
    /**
     * @param articleId 
     * @return
     */
    public abstract ResultSet select(String articleId);

    /**
     * @return
     */
    public abstract ResultSet selectAll() ;

    /**
     * @param articleId 
     * @param descprtion 
     * @param quantity 
     * @return
     */
    public abstract boolean update(String articleId, String descprtion, int quantity) ;

}