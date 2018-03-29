package facade;

import persistent.daos.TransactionDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.util.*;

/**
 * 
 */
public class InventoryFacade {

    private TransactionDAO transactionDao;

    private final DaoFactory factory;
    private FacadeManager facadeManager;

    /**
     * Default constructor
     */
    public InventoryFacade() {
        factory = DaoPostgresFactory.getInstance();
        this.transactionDao = factory.createTransactionDAO();
    }





    /**
     * @param name 
     * @param description 
     * @param quantity 
     * @param type 
     * @return
     */
    public boolean addArticle(String name, String description, int quantity, String type) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @return
     */
    public boolean deleteArticle(String name) {
        // TODO implement here
        return false;
    }

    /**
     * @param capacity 
     * @param name
     */
    public void updateArticle(int capacity, String name) {
        // TODO implement here
    }

    /**
     * @param type 
     * @return
     */
    public ArrayList<String> getArticles(String type) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<String> getTypes() {
        // TODO implement here
        return null;
    }

}