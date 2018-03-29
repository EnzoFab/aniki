package persistent.daos;

import business_logic.Event;
import business_logic.Team;
import business_logic.Transaction;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public abstract class TransactionDAO extends DAO{


    public TransactionDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param transaction 
     * @return
     */
    public abstract boolean insert(Transaction transaction);
    /**
     * @param idT 
     * @return
     */
    public  abstract boolean delete(int idT) ;


    /**
     * @param idT
     * @return
     */
    public abstract boolean update(int idT) ;

    /**
     * @param team 
     * @return
     */
    public abstract ResultSet selectFromTeam(Team team) ;

    /**
     * @param event 
     * @return
     */
    public abstract ResultSet selectFromEvent(Event event);

    /**
     * @return
     */
    public abstract ResultSet selectAll();

    public abstract ResultSet selectLast();

    public abstract boolean insertPaymentMethod(int idT, String paymentmethod_name);

}