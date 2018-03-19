package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class BudgetDAO extends DAO {

    /**
     * Default constructor
     */
    public BudgetDAO(Connection c) {
        super(c);
    }


    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}