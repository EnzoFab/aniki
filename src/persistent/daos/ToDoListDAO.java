package persistent.daos;

import business_logic.ToDoList;

import java.sql.Connection;

/**
 * 
 */
public abstract class ToDoListDAO extends DAO {

    /**
     * Default constructor
     */
    public ToDoListDAO(Connection c) {
        super(c);
    }


    /**
     * @param  taskId
     * @return
     */
    public abstract ToDoList addNewTask( String taskId);

    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}