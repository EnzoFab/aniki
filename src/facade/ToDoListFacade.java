package facade;

import business_logic.Event;

import java.util.*;

/**
 * 
 */
public class ToDoListFacade {

    /**
     * Default constructor
     */
    public ToDoListFacade() {
    }

    /**
     * 
     */
    private Event event;





    /**
     * @param label 
     * @return
     */
    public boolean addToDoList(String label) {
        // TODO implement here
        return false;
    }

    /**
     * Delete the task that matchs with the primary key
     * @param idTD : primary key
     * @return true if the action is executed with success
     */
    public boolean deleteToDoList(int idTD) {
        // TODO implement here
        return false;
    }

    /**
     * add a new Task to the TODO list
     * return true if action is a success
     * @param idTD 
     * @param name 
     * @param date 
     * @return
     */
    public boolean addTask(int idTD, String name, Date date) {
        // TODO implement here
        return false;
    }

    /**
     * Delete a task to the TODO List
     * return true if the action is done with success
     * @param idTa 
     * @return
     */
    public boolean deleteTask(int idTa) {
        // TODO implement here
        return false;
    }

    /**
     * @param idTa 
     * @return
     */
    public boolean validateTask(int idTa) {
        // TODO implement here
        return false;
    }

    /**
     * Update the name of A Todo list
     * @param idTD 
     * @param label 
     * @return
     */
    public boolean updateToDoList(int idTD, String label) {
        // TODO implement here
        return false;
    }

}