package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class ArticleDAO extends DAO {

    /**
     * Default constructor
     */
    public ArticleDAO(Connection c) {
        super(c);
    }


    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}