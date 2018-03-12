package persistent.daos;

import java.sql.Connection;

public abstract class Dao {
    private Connection connect;

    public Dao(Connection c){
        connect = c;
    }

    public abstract void deleteById(String id);

    public Connection getConnect(){
        return connect;
    }
}
