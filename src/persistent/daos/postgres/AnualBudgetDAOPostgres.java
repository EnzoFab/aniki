package persistent.daos.postgres;

import business_logic.AnualBudget;
import helpers.Couple;
import persistent.daos.AnualBudgetDAO;

import java.sql.Connection;

/**
 * 
 */
public class AnualBudgetDAOPostgres extends AnualBudgetDAO {


    public AnualBudgetDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean deleteByID(String id) {
        return false;
    }

    @Override
    public boolean insert(int amount, int year, String listName) {
        return false;
    }

    @Override
    public boolean insert(AnualBudget anual) {
        return false;
    }
}