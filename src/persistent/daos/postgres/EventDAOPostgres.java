package persistent.daos.postgres;

import business_logic.Event;
import persistent.daos.EventDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("INSERT INTO event ('event_label', 'event_date_start', 'event_date_end', 'event_number_entrant') VALUES ('"+event.getLabel()+"', '"+event.getDateStart()+"', '"+event.getDateEnd()+"', '"+event.getNumberEntrant()+"', '");
            if(set.first())
                return true;
            else return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ResultSet select(String idE) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM event E WHERE E.event_id == '"+idE+"'");
            if(set.first())
                return set;
            else return  null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet selectAll() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM event");
            if(set.first())
                return set;
            else return  null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(int idE) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("DELETE FROM event WHERE event_id == '"+idE+"'");
            if(set.first())
                return true;
            else return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int idE, String label, Date date_start, Date date_end, int number_entrant){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("UPDATE event SET event_label = '"+label+"', event_date_start = '"+date_start+"', event_date_end = '"+date_end+"', event_number_entrant = '"+number_entrant+"' WHERE event_id == '"+idE+"'");
            if(set.first())
                return true;
            else return  false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}