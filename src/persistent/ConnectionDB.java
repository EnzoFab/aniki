package persistent;

import logs.ConnectionLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDB {

    private static Connection connect;

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
