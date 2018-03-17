package persistent.daos;

import helpers.Couple;

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

    /**
     * Update a user given by his mail
     * @param mail
     * @param setData
     * @return
     * @see Couple
     */
    public abstract boolean update(String mail, Couple ...setData);
}
