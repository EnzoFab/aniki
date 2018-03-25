package persistent.daos.postgres;

import business_logic.ToDoList;
import persistent.daos.ToDoListDAO;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public class ToDoListDAOPostgres extends ToDoListDAO {


    public ToDoListDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean delete(ToDoList todolist) {
        return false;
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }
}