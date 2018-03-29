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
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("INSERT INTO transaction (transaction_label, transaction_amount, transaction_date, transaction_state, transaction_type) VALUES ('"+transaction.getLabel()+"', '"+transaction.getAmount()+"', '"+transaction.getDate()+"', "+transaction.getState()+", '"+transaction.getType()+"')");
            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int idT) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("DELETE FROM transaction WHERE transaction_id = '"+idT+"'");
            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int idT) {
        Connection connect = getConnection();
        try {
            System.out.println(idT);
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("UPDATE transaction SET transaction_state = '1' WHERE transaction_id = "+idT);
            return numberRowModified == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
            ResultSet set =  state.executeQuery("SELECT * FROM transaction ");
            return set;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet selectLast() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM transaction");
            if(set.last())

                return set;
            else return  null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertPaymentMethod(int idT, String paymentmethod_name){
        Connection connect = getConnection();
        try {
            System.out.println(idT);
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("UPDATE transaction SET paymentmethod_name = '"+"CB"+"' WHERE transaction_id = "+idT);
            return numberRowModified == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}