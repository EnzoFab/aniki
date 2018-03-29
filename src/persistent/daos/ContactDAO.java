package persistent.daos;

import java.sql.Connection;
import java.sql.ResultSet;

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
    public abstract boolean insert(String name, String first_name, String place, String mail, String phoneNumber);

    /**
     * @return
     */
    public abstract boolean insertLink(int idE, int idC);

    /**
     * @param
     * @return
     */
    public abstract boolean deleteLink(int idE, int idC);

    public abstract boolean delete(int idC);

    public abstract ResultSet selectLast() ;

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

    public abstract ResultSet selectAll(int idE);
    /**
     * 
     */
    public abstract boolean deleteAssocationEvent(String contact,  String event);

    /**
     * 
     */
    public abstract boolean update(int idC, String name, String first_name, String place,  String phone, String mail);
}