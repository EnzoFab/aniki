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
    public abstract boolean insert(Event event, String team_name) ;
    /**
     * @param event 
     * @return
     */
    public abstract ResultSet select(int event) ;

    public abstract ResultSet selectLast() ;

    /**
     * @return
     */
    public abstract ResultSet selectAll() ;

    /**
     * @param  idE
     * @return
     */
    public abstract boolean delete(int idE, String team_name);

    public abstract boolean update(int idE, String label, Date date_start,Date date_end, int number_entrant, String team_name);

    public abstract ResultSet getEventsWithoutBudget();

    public abstract ResultSet selectEventWithNameWithoutBudget(String name);

    public abstract ResultSet selectAllTeam();
}

