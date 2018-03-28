package persistent.daos.postgres;

import business_logic.Event;
import persistent.daos.EventDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

/**
 * 
 */
public class EventDAOPostgres extends EventDAO {


    public EventDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(Event event) {
        return true;
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
    public boolean delete(int idE) {
        return false;
    }

    public boolean update(int idE, String label, Date date_start, Date date_end, int number_entrant){
        return false;
    }
}