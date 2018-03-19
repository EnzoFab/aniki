package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class TransactionDAO extends DAO {

    /**
     * Default constructor
     */
    public TransactionDAO(Connection c) {
        super(c);
    }


    /**
     * @param id
     * @return
     */
    public abstract void deleteByID(String id);

}