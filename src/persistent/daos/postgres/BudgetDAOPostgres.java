package persistent.daos.postgres;

import business_logic.Budget;
import persistent.daos.BudgetDAO;

import java.sql.Connection;

/**
 * 
 */
public class BudgetDAOPostgres extends BudgetDAO {


    public BudgetDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Budget budget, String team) {
        return false;
    }

    @Override
    public boolean delete(Budget budget) {
        return false;
    }
}