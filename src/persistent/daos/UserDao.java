package persistent.daos;

import business_logic.User;
import persistent.daos.Dao;

import java.sql.Connection;

public abstract class UserDao extends Dao {
    public UserDao(Connection c){
        super(c);
    }

    public abstract User create(String mail, String pwd);

    public abstract User getUserById(String mail);
}
