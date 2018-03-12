package persistent.daos;

import business_logic.User;
import persistent.daos.UserDao;

import java.sql.Connection;

public class UserDaoPostgres extends UserDao {
    public UserDaoPostgres(Connection c){
        super(c);
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public User create(String mail, String pwd) {
        return null;
    }

    @Override
    public User getUserById(String mail) {
        return null;
    }
}
