package persistent.daos;

import business_logic.Budget;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class BudgetDAO extends DAO {


    public BudgetDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param budget 
     * @param team 
     * @return
     */
    public abstract boolean insert(Budget budget, String team);

    /**
     * @param budget 
     * @return
     */
    public abstract boolean delete(Budget budget);
}