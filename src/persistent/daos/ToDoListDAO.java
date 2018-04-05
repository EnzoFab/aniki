package persistent.daos;

import business_logic.ToDoList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * Provides methods that allow to manage the TOdOLIST Table
 */
public abstract class ToDoListDAO extends DAO{

    /**
     * @see DAO
     * @param connection
     */
    public ToDoListDAO(Connection connection) {
        super(connection);
    }

    /**
     * Insert a todolist and link it to an existing event
     * If the operation fails return false otherwise return true
     * @param todolist 
     * @param event 
     * @return
     */
    public boolean insert(ToDoList todolist, String event) {
        // TODO implement here
        return false;
    }

    /**
     * @param todolist 
     * @return
     */
    public abstract boolean delete(ToDoList todolist) ;

    /**
     * @see ResultSet
     * @return
     */
    public abstract ResultSet selectAll();

}