package persistent.daos;

import business_logic.AnualBudget;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class AnualBudgetDAO extends DAO {


    public AnualBudgetDAO(Connection connection) {
        super(connection);
    }

    public abstract boolean deleteByID(String id);


    public abstract boolean insert(int amount, int year, String listName);

    /**
     * @param anual 
     * @return
     */
    public abstract boolean insert(AnualBudget anual);

}