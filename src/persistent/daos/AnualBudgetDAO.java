package persistent.daos;

import business_logic.AnualBudget;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public abstract class AnualBudgetDAO extends DAO {


    public AnualBudgetDAO(Connection connection) {
        super(connection);
    }

    public abstract boolean deleteByID(int id);


    public abstract boolean insert(int amount, int year, String listName);

    /**
     * @param anual 
     * @return
     */
    public abstract boolean insert(AnualBudget anual);

    public abstract  boolean update(String id, int amount);

    public abstract ResultSet getTransaction();

    public abstract  ResultSet getAll();

    public abstract ResultSet getAnualBudgetFromYear(int year);
}