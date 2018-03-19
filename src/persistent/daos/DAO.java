package persistent.daos;

import business_logic.User;
import helpers.Couple;

import java.sql.Connection;

public abstract class DAO {

    private final Connection connect;

    public DAO(Connection c){
        connect = c;
    }


    public abstract void deleteById(String id);

    protected final Connection getConnect(){
        return connect;
    }

    /**
     * @param  param
     * @return
     */
    public abstract boolean insert(String ...param);

    /**
     * Update a user given by his mail
     * @param mail
     * @param setData
     * @return
     * @see Couple
     */
    public abstract boolean update(String mail, Couple ...setData);
}
