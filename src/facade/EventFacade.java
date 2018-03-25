package facade;

import business_logic.Team;

import java.util.*;

/**
 * 
 */
public class EventFacade {

    /**
     * Default constructor
     */
    public EventFacade() {
    }

    /**
     * 
     */
    private Team team;






    /**
     * @param name 
     * @param date 
     * @param capacity 
     * @return
     */
    public boolean addEvent(String name, Date date, int capacity) {
        // TODO implement here
        return false;
    }

    /**
     * @param idE 
     * @return
     */
    public boolean deleteEvent(int idE) {
        // TODO implement here
        return false;
    }

    /**
     * @param idE 
     * @param name 
     * @param date 
     * @param capacity 
     * @return
     */
    public boolean updateEvent(int idE, String name, Date date, int capacity) {
        // TODO implement here
        return false;
    }

    /**
     * @param idE 
     * @param idC 
     * @return
     */
    public boolean addLink(int idE, int idC) {
        // TODO implement here
        return false;
    }

    /**
     * @param idE 
     * @param idC 
     * @return
     */
    public boolean deleteLink(int idE, int idC) {
        // TODO implement here
        return false;
    }

    /**
     * @param idE 
     * @return
     */
    public ArrayList getAllContactForEvent(int idE) {
        // TODO implement here
        return null;
    }

}