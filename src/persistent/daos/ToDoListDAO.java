package persistent.daos;

import business_logic.ToDoList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public abstract class ToDoListDAO extends DAO{


    public ToDoListDAO(Connection connection) {
        super(connection);
    }

    /**
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
     * @return
     */
    public abstract ResultSet selectAll();

}