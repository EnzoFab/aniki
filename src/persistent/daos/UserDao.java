package persistent.daos;

import business_logic.User;
import persistent.daos.Dao;

import java.sql.Connection;

public abstract class UserDao extends Dao {


    public UserDao(Connection c){
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
}
