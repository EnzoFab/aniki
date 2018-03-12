package persistent;

import logs.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionDB {

    private static Connection connect;

    public static Connection getInstance()
    {
        if(connect == null){
            try {
                connect = DriverManager.getConnection(Log.getUrl(), Log.getUser(), Log.getPwd());
                System.out.println("Connexion effective !");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connexion failed !");
               connect = null;
            }
        }
        return  connect;
    }

}
