package persistent.daos.postgres;

import business_logic.Task;
import persistent.daos.TaskDAO;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class TaskDAOPostgres extends TaskDAO {


    public TaskDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Task task, String idToDoList) {
        return false;
    }

    @Override
    public boolean delete(String idTask) {
        return false;
    }

    @Override
    public boolean update(Task task) {
        return false;
    }
}