package persistent.daos;

import java.sql.Connection;

/**
 * 
 */
public abstract class ContactDAO extends DAO {

    /**
     * Default constructor
     */
    public ContactDAO(Connection c) {
        super(c);
    }


    /**
     * @param id
     * @return
     */
    public abstract void deleteByID( String id);

}