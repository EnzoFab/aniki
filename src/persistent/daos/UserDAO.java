package persistent.daos;

import business_logic.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 */
public abstract class UserDAO extends DAO {

    /**
     * @see DAO
     * @param c
     */
    public UserDAO(Connection c){
        super(c);
    }

    /**
     * @param user
     * @return
     */
    public abstract boolean insert(User user) ;

    /**
     * Giving a idea insert a model User if one user with this id exists
     * else null is returned
     * @see ResultSet
     * @param mail
     * @return
     */
    public abstract ResultSet select(String mail);

    /**
     * Update the user that match the mail parameter
     * All attribute value can be updated. If you don't want to update every value of the row
     * just give the previous value
     * @param mail
     * @param firstName
     * @param name
     * @param pwd
     * @param phone
     * @return
     */
    public abstract boolean update(String mail, String firstName, String name, String pwd, String phone);



    /**
     * Select all User that belong to the Team
     * @param  idTeam : primary key of the Team table
     * @return
     */
    public abstract ResultSet selectByTeam(String idTeam);

    /**
     * @see ResultSet
     * @param  mail
     * @return
     */
    public abstract boolean delete( String mail);

    /**
     * Select all existing User
     * @see ResultSet
     * @return
     */
    public abstract ResultSet selectAll();


}
