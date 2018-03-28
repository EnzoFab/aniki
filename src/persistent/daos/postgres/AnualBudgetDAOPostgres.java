package persistent.daos.postgres;

import business_logic.AnualBudget;
import persistent.daos.AnualBudgetDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class AnualBudgetDAOPostgres extends AnualBudgetDAO {


    public AnualBudgetDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean deleteByID(int id) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("DELETE FROM anualbudget WHERE anualbudget_id == '"+id+"'");
            if(set.first())
                return true;
            else return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(int amount, int year, String listName) {
        return false;
    }

    @Override
    public boolean insert(AnualBudget anual) {
        return false;
    }

    @Override
    public boolean update(String id, int amount){
        return false;
    }

    @Override
    public ResultSet getTransaction(){
        return null;
    }
}