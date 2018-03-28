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
     * @return
     */
    public abstract boolean insert();

    /**
     * @return
     */
    public abstract boolean insertLink(int idE, int idC);

    /**
     * @param
     * @return
     */
    public abstract boolean deleteLink(int idE, int idC);

    /**
     * @param contactId 
     * @return
     */
    public abstract ResultSet select(int contactId);

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