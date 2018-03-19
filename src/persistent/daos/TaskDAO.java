package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class TaskDAO extends DAO {

    /**
     * Default constructor
     */
    public TaskDAO(Connection c) {
        super(c);
    }


    /**
     * @param id
     * @return
     */
    public abstract void deleteByID( String id);

}