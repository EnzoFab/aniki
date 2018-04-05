package persistent.daos;

import business_logic.Task;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class TaskDAO extends DAO {

    /**
     * @see DAO
     * @param connection
     */
    public TaskDAO(Connection connection) {
        super(connection);
    }

    /**
     * Try to insert a new tuble in the Task table that is directly linked to the TODOLIST
     * @param  task
     * @param  idToDoList
     * @return
     */
    public abstract boolean insert(Task task, String idToDoList);

    /**
     *
     * @param  idTask
     * @return
     */
    public abstract boolean delete( String idTask) ;

    /**
     * @param  task
     * @return
     */
    public  abstract boolean update( Task task);

}