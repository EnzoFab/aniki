package persistent.daos;

import java.sql.Connection;

public abstract class Dao {

    private final Connection connect;

    public Dao(Connection c){
        connect = c;
    }


    public abstract void deleteById(String id);

    protected final Connection getConnect(){
        return connect;
    }
}
