package persistent.factories;

import persistent.ConnectionDB;
import persistent.daos.UserDao;

import java.sql.Connection;

/**
 * Singleton class uses to create a DaoObject
 */
public abstract class DaoFactory {

    protected final Connection connect;

    protected static DaoFactory factory;

    protected DaoFactory(){
        this.connect = ConnectionDB.getInstance();
    }

    /**
     * get the unique instance of DaoFactory
     * @return
     */
    public static DaoFactory getInstance(){
        return factory;
    }


    /**
     * Create an UserDao
     * @return
     */
    public abstract UserDao createUserDao();

}
