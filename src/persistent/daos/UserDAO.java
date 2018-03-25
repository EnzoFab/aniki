package persistent.daos;

import business_logic.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class UserDAO extends DAO {


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
     * @param mail
     * @return
     */
    public abstract ResultSet select(String mail);

    /**
     * @param mail
     * @param firstName
     * @param name
     * @param pwd
     * @param phone
     * @return
     */
    public abstract boolean update(String mail, String firstName, String name, String pwd, String phone);



    /**
     * @param  idTeam
     * @return
     */
    public abstract ResultSet selectByTeam(String idTeam);

    /**
     * @param  mail
     * @return
     */
    public abstract boolean delete( String mail);

    public abstract ResultSet selectAll();


}
