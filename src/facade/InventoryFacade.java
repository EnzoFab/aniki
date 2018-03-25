package facade;

import java.util.*;

/**
 * 
 */
public class InventoryFacade {

    /**
     * Default constructor
     */
    public InventoryFacade() {
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