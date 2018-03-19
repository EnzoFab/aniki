package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class AnualBudgetDAO extends DAO {

    /**
     * Default constructor
     */
    public AnualBudgetDAO(Connection c) {
        super(c);
    }


    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}