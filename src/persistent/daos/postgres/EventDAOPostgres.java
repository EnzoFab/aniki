package persistent.daos.postgres;

import business_logic.Event;
import persistent.daos.EventDAO;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public class EventDAOPostgres extends EventDAO {


    public EventDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public void insert(Event event) {

    }

    @Override
    public ResultSet select(String event) {
        return null;
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }

    @Override
    public boolean delete(Event String) {
        return false;
    }
}