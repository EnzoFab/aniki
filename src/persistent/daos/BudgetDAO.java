package persistent.daos;

import business_logic.Budget;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public abstract class BudgetDAO extends DAO {


    public BudgetDAO(Connection connection) {
        super(connection);
    }

    /**Insert a new budget in the data base
     * @param budget: budget compose with an amount, an event and a team
     * @return
     */
    public abstract boolean insert(Budget budget);

    /**
     * delete a budget in the data base
     * @param budget 
     * @return
     */
    public abstract boolean delete(Budget budget);

    /**
     *
     * @param budgetId
     * @return
     */
    public abstract ResultSet select(int budgetId) ;

    /**
     *
     * @return
     */
    public abstract ResultSet selectAll();
}