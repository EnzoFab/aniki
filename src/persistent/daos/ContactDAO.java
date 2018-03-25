package persistent.daos;

import business_logic.Contact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public abstract class ContactDAO extends  DAO {


    public ContactDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param contact 
     * @return
     */
    public boolean insert(Contact contact) {
        // TODO implement here
        return false;
    }

    /**
     * @param contact 
     * @return
     */
    public boolean delete(Contact contact) {
        // TODO implement here
        return false;
    }

    /**
     * @param contactId 
     * @return
     */
    public ResultSet select(String contactId) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public abstract ResultSet selectAll();
    /**
     * 
     */
    public abstract ResultSet selectAll(String team);
    /**
     * 
     */
    public abstract boolean deleteAssocationEvent(String contact,  String event);

    /**
     * 
     */
    public abstract boolean update(String name, String place,  String phone, String mail);
}