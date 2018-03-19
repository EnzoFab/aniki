package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class EventDAO extends DAO {

    /**
     * Default constructor
     */
    public EventDAO(Connection c) {
        super(c);
    }


    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}