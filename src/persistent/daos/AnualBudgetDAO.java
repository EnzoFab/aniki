package persistent.daos;

import business_logic.AnualBudget;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Class which has interaction with the table AnualBudget
 * @see DAO
 */
public abstract class AnualBudgetDAO extends DAO {

    /**
     *
     * @param connection
     */
    public AnualBudgetDAO(Connection connection) {
        super(connection);
    }

    public abstract boolean deleteByID(int id);


    /**
     *Try to insert a new anual budget, return true if it's done with success
     * @param amount: The amount initially awarded to the student union
     * @param year: The year when the student union took office
     * @param listName : list of the student union during thr campaign
     * @return
     */
    public abstract boolean insert(int amount, int year, String listName);

    /**
     *Try to insert a new anual budget, return true if it's done with success
     * @param anual : An model object that encapsulate data
     * @return
     */
    public abstract boolean insert(AnualBudget anual);

    /**
     * Try to update an AnualBudget
     * @param id
     * @param amount
     * @param year
     * @return
     */
    public abstract  boolean update(String id, int amount, String year);

    public abstract ResultSet getTransaction();

    /**
     * Return all the existing AnualBudget
     * @return
     */
    public abstract  ResultSet getAll();

    public abstract ResultSet getAnualBudgetFromYear(int year);
}