package persistent.daos.postgres;

import business_logic.Event;
import business_logic.Team;
import business_logic.Transaction;
import persistent.daos.TransactionDAO;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public class TransactionDAOPostgres extends TransactionDAO {


    public TransactionDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Transaction transaction) {
        return false;
    }

    @Override
    public boolean delete(String idT) {
        return false;
    }

    @Override
    public boolean update(Transaction transaction) {
        return false;
    }

    @Override
    public ResultSet selectFromTeam(Team team) {
        return null;
    }

    @Override
    public ResultSet selectFromEvent(Event event) {
        return null;
    }
}