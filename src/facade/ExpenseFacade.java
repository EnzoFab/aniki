package facade;

import business_logic.Budget;
import business_logic.LightUser;

import java.util.*;

/**
 * 
 */
public class ExpenseFacade {

    /**
     * Default constructor
     */
    public ExpenseFacade() {
    }

    /**
     * 
     */
    private Budget budget;










    /**
     * @param amount  
     * @param label 
     * @param type 
     * @param date 
     * @return
     */
    public boolean addTransaction(int amount , String label, String type, Date date) {
        // TODO implement here
        return false;
    }

    /**
     * @param idT 
     * @return
     */
    public boolean deleteTransaction(int idT) {
        // TODO implement here
        return false;
    }

    /**
     * @param idT  
     * @return
     */
    public boolean validate(int idT ) {
        // TODO implement here
        return false;
    }

    /**
     * @param receipt 
     * @param idT 
     * @return
     */
    public boolean addReceipt(String receipt, int idT) {
        // TODO implement here
        return false;
    }

    /**
     * @param idT 
     * @return
     */
    public boolean deleteReceipt(int idT) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<LightUser> getAllTransaction() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getBalance() {
        // TODO implement here
        return 0;
    }

}