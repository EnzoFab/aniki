package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class StoryMadeDAO extends DAO {

    /**
     * Default constructor
     */
    public StoryMadeDAO(Connection c) {
        super(c);
    }


    /**
     * @param id
     * @return
     */
    public abstract void deleteByID( String id);

}