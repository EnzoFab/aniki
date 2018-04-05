package persistent.daos;

import business_logic.Article;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * provides methods that are linked to the Article table
 * and type as well
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
     * try to delete a tuple given by the ida
     * @param idA
     * @return
     */
    public abstract boolean delete(int idA);

    /**
     * Select the article that match the id given in parameter
     * @param articleId 
     * @return
     */
    public abstract ResultSet select(String articleId);

    /**
     * Select the last article
     * @return
     */
    public abstract ResultSet selectLast() ;

    /**
     * Return all the existing Article in the database
     * if an error is encountred return null
     * @return
     */
    public abstract ResultSet selectAll() ;

    /**
     * Tries to update and Article given by its Id
     * @param articleId
     * @param description
     * @param quantity
     * @return
     */
    public abstract boolean update(String articleId, String description, int quantity) ;

    /**
     *
     * @return
     */
    public abstract ResultSet selectAllType();

    /**
     * Insert a new row in the Type table
     * @param type
     * @return
     */
    public abstract boolean insertType(String type);

}