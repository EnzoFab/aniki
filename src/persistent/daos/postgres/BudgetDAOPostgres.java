package persistent.daos.postgres;

import business_logic.Budget;
import persistent.daos.BudgetDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 * 
 */
public class BudgetDAOPostgres extends BudgetDAO {


    public BudgetDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Budget budget) {
        Connection connect = getConnection();
        try {
            Calendar calendrier;
            calendrier = Calendar.getInstance();
            int anneeEnCours = calendrier.get(Calendar.YEAR);
            connect.setAutoCommit(false);
            Statement state = connect.createStatement();
            String sql = "insert into budget(budget_amount, anualbudget_id, team_id)"
                    +"values ("+budget.getAmount()+", "+anneeEnCours+", "+budget.getEvent()+");";
            state.executeUpdate(sql);
            state.close();
            connect.commit();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hello");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Budget budget) {
        return false;
    }

    @Override
    public ResultSet select(int budgetId) {
        return null;
    }

    @Override
    public ResultSet selectAll(){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM budget WHERE event_id IS NOT NULL");
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}