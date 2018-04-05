package persistent.daos;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * This Dao link the Contact table from database and facades. We can insert, delete, select and update
 */
public abstract class ContactDAO extends  DAO {

    /**
     * @see DAO
     * @param connection
     */
    public ContactDAO(Connection connection) {
        super(connection);
    }

    /**
     *
     * @param name
     * @param first_name
     * @param place
     * @param mail
     * @param phoneNumber
     * @return
     *
     * Insert a new contact into the Database
     *
     */
    public abstract boolean insert(String name, String first_name, String place, String mail, String phoneNumber);

    /**
     *
     * @param idC
     * @param team_name
     * @return
     *
     * insert a new link between a contact and a team into the Database
     *
     */
    public abstract boolean insertLink(int idC, String team_name);

    /**
     *
     * @param idC
     * @param team_name
     * @return
     *
     * Delete a link between a contact and a team into the Database
     *
     */
    public abstract boolean deleteLink(int idC, String team_name);

    /**
     *
     * @param idC
     * @return
     *
     * Delete a contact from the Database
     *
     */
    public abstract boolean delete(int idC);

    /**
     *
     * @return
     *
     * Return the last contact of the Database
     *
     */
    public abstract ResultSet selectLast() ;

    /**
     * @param contactId 
     * @return
     *
     * Select a contact from his id into the database
     *
     */
    public abstract ResultSet select(int contactId);

    /**
     * @return
     *
     * Select all contact of the Database
     *
     */
    public abstract ResultSet selectAll();

    /**
     *
     * @param idE
     * @return
     *
     * Select all contact of a single event fro mthe database
     *
     */
    public abstract ResultSet selectAll(int idE);

    /**
     *
     * @param contact
     * @param event
     * @return
     *
     * Delete a link from the database between a contact and a event
     *
     */
    public abstract boolean deleteAssocationEvent(String contact,  String event);

    /**
     *
     * @param idC
     * @param name
     * @param first_name
     * @param place
     * @param phone
     * @param mail
     * @return
     *
     * Update all attributes of a contact from the database
     *
     */
    public abstract boolean update(int idC, String name, String first_name, String place,  String phone, String mail);
}