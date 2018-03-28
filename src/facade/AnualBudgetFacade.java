package facade;

import business_logic.AnualBudget;
import persistent.daos.AnualBudgetDAO;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public class AnualBudgetFacade {

    private AnualBudgetDAO anualBudgetDAO;
    private AnualBudget anualBudget;
    private ResultSet allTransaction;
    private ArrayList<AnualBudget> allAnualBudget;

    /**
     * Default constructor
     */
    public AnualBudgetFacade() {
        this.anualBudgetDAO = DaoPostgresFactory.getInstance().createAnualBudgetDAO();
    }





    /**
     * @param listName 
     * @param year 
     * @param amount 
     * @return
     */
    public boolean create(String listName, int year, int amount) {
        // TODO implement here
        AnualBudget anualB = new AnualBudget(amount, year, listName);
        boolean value = this.anualBudgetDAO.insert(anualB);
        if(value) {
            this.anualBudget = anualB;
            System.out.println("hey");
            return true;
        }
        return false;
    }

    /**
     * @param listName 
     * @param amount
     * @return
     */
    public boolean update(String listName, int amount) {
        // TODO implement here
        if(this.anualBudgetDAO.update(listName, amount)){
            return true;
        }
        return false;
    }

    /**
     * @return
     */
    public ArrayList getAll() {
        // TODO implement here
        ResultSet transaction = this.anualBudgetDAO.getTransaction();
        this.allTransaction = transaction;
        return (ArrayList) transaction;
    }

    /**
     * @param year 
     * @return
     */
    public boolean delete(int year) {
        // TODO implement here
        if(this.anualBudgetDAO.deleteByID(year)){
            return true;
        }
        return false;
    }

}