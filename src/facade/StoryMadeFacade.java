package facade;

import business_logic.Event;
import business_logic.User;

import java.util.*;

/**
 * Make the link between view, buisiness logic and persistent data that deals with StoryMade
 * Not implemented yet
 */
public class StoryMadeFacade {

    private final User connectedUser;

    /**
     * Default constructor
     * @param connectedUser
     */
    public StoryMadeFacade(User connectedUser) {
        this.connectedUser = connectedUser;
    }

    /**
     * 
     */
    private Event event;



    /**
     * @param date 
     * @param text 
     * @param label 
     * @return
     */
    public boolean addStoryMade(Date date, String text, String label) {
        // TODO implement here
        return false;
    }

    /**
     * @param idS 
     * @param date 
     * @param text 
     * @param label 
     * @return
     */
    public boolean updateStoryMade(int idS, Date date, String text, String label) {
        // TODO implement here
        return false;
    }

    /**
     * @param idS 
     * @return
     */
    public boolean deleteStoryMade(int idS) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<String> getAllStoryMade() {
        // TODO implement here
        return null;
    }

}