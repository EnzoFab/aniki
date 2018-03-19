package persistent.daos;

import business_logic.User;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class UserDAO extends DAO {


    public UserDAO(Connection c){
        super(c);
    }

    /**
     * insert a new User in the database
     * return the user insert in case of success
     * else return null
     * @param mail
     * @param pwd
     * @return
     */
    public abstract User insert(String mail, String pwd);

    /**
     * Giving a idea insert a model User if one user with this id exists
     * else null is returned
     * @param mail
     * @return
     */
    public abstract User getUserById(String mail);



    /**
     * @param  idTeam
     * @return
     */
    public abstract ArrayList getAllUserByTeam( String idTeam);

    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);


}
