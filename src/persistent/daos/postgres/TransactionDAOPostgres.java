package persistent.daos.postgres;

import business_logic.Event;
import business_logic.Team;
import business_logic.Transaction;
import persistent.daos.TransactionDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    @Override
    public ResultSet selectAll() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM transaction  ");
            return set;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}