package persistent;

import logs.ConnectionLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A factory which role is to create a Connection instance
 * in order to connect to the database
 */
public class ConnectionDB {

    private static Connection connect;

    private ConnectionDB(){}

    /**
     * Try to connect to the database
     * @return
     */
    public static Connection getInstance()
    {
        if(connect == null){
            try {
                connect = DriverManager.getConnection(ConnectionLog.getUrl(), ConnectionLog.getUser(), ConnectionLog.getPwd());
                System.out.println("Connection effective !");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection failed !");
               connect = null;
            }
        }
        return  connect;
    }

}
