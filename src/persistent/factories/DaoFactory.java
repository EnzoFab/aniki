package persistent.factories;

import persistent.ConnectionDB;
import persistent.daos.UserDao;

import java.sql.Connection;

/**
 * Create Dao object
 */
public abstract class DaoFactory {
    protected Connection connect;

    public abstract UserDao createUserDao();

}
