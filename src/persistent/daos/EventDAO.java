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
     * @param team_name
     * @return
     *
     * Insert the given event into the Database
     *
     */
    public abstract boolean insert(Event event, String team_name) ;

    /**
     * @param event 
     * @return
     *
     * Select the event with the id given
     *
     */
    public abstract ResultSet select(int event) ;

    /**
     * @return
     *
     * Select the last event added into the Database
     *
     */
    public abstract ResultSet selectLast() ;

    /**
     * @return
     *
     * Select all event of the Database
     *
     */
    public abstract ResultSet selectAll() ;

    /**
     * @param  idE
     * @return
     *
     * Delete the event create by the team given, with the id given
     *
     */
    public abstract boolean delete(int idE, String team_name);

    /**
     * @param idE
     * @param label
     * @param date_start
     * @param date_end
     * @param number_entrant
     * @param team_name
     * @return
     *
     * Update all attribute of the event given by the id
     *
     */
    public abstract boolean update(int idE, String label, Date date_start,Date date_end, int number_entrant, String team_name);

    public abstract ResultSet getEventsWithoutBudget();

    public abstract ResultSet selectEventWithNameWithoutBudget(String name);

    public abstract ResultSet selectAllTeam();
}

