package persistent.daos.postgre;

import business_logic.ToDoList;
import helpers.Couple;
import persistent.daos.ToDoListDAO;

import java.sql.Connection;

public class ToDoListDAOPostgres extends ToDoListDAO {

    /**
     * Default constructor
     *
     * @param c
     */
    public ToDoListDAOPostgres(Connection c) {
        super(c);
    }

    @Override
    public ToDoList addNewTask(String taskId) {
        return null;
    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public boolean insert(String... param) {
        return false;
    }

    @Override
    public boolean update(String mail, Couple... setData) {
        return false;
    }
}
