package persistent.daos;

import business_logic.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public abstract class EventDAO  extends DAO{


    public EventDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param event
     */
    public abstract boolean insert(Event event) ;
    /**
     * @param event 
     * @return
     */
    public abstract ResultSet select(String event) ;

    /**
     * @return
     */
    public abstract ResultSet selectAll() ;

    /**
     * @param  idE
     * @return
     */
    public abstract boolean delete(int idE);

    public abstract boolean update(int idE, String label, Date date_start,Date date_end, int number_entrant);
}

