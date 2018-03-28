package facade;

import business_logic.Contact;
import business_logic.Event;
import business_logic.Team;
import persistent.daos.ContactDAO;
import persistent.daos.EventDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public class EventFacade {

    /**
     * attributes
     */
    private Team team;
    private EventDAO eventDao;
    private ContactDAO contactDao;
    private ArrayList<Event> eventList;

    /**
     * Default constructor
     */
    public EventFacade() {
        this.eventDao = DaoPostgresFactory.getInstance().createEventDAO();
        this.contactDao = DaoPostgresFactory.getInstance().createContactDAO();
    }

    /**
     * @param label
     * @param date_start
     * @param date_end
     * @param number_entrant
     * @return
     */
    public boolean addEvent(String label, Date date_start,Date date_end, int number_entrant) {
        Event event = new Event(label, date_start, date_end, number_entrant);
        this.eventDao.insert(event);
        return false;
    }

    /**
     * @return
     */
    public boolean getAllEvent() {
        ResultSet result = this.eventDao.selectAll();
        // Traitement du result a faire
        return false;
    }

    /**
     * @param idE 
     * @return
     */
    public boolean deleteEvent(int idE) {
        this.eventDao.delete(idE);
        return false;
    }

    /**
     * @param idE 
     * @param label
     * @param date_start
     * @param date_end
     * @param number_entrant
     * @return
     */
    public boolean updateEvent(int idE, String label, Date date_start, Date date_end, int number_entrant) {
        this.eventDao.update(idE, label, date_start, date_end, number_entrant);
        return false;
    }

    /**
     * @param idE 
     * @param idC 
     * @return
     */
    public boolean addLink(int idE, int idC) {
        boolean state = this.contactDao.insertLink(idE, idC);
        return state;
    }

    /**
     * @param idE 
     * @param idC 
     * @return
     */
    public boolean deleteLink(int idE, int idC) {
        // TODO implement here
        return false;
    }

    /**
     * @param idE 
     * @return
     */
    public ArrayList getAllContactForEvent(int idE) {
        // TODO implement here
        return null;
    }

}