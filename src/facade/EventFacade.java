package facade;

import business_logic.Event;
import business_logic.Team;
import persistent.daos.ContactDAO;
import persistent.daos.EventDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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

    private final DaoFactory factory;
    private FacadeManager facadeManager;

    /**
     * Default constructor
     */
    public EventFacade() {
        factory = DaoPostgresFactory.getInstance();
        this.eventDao = factory.createEventDAO();
        this.contactDao = factory.createContactDAO();
        this.eventList = new ArrayList<>();
        this.team = new Team("com");
    }

    /**
     * @param label
     * @param date_start
     * @param date_end
     * @param number_entrant
     * @return
     */
    public boolean addEvent(String label, Date date_start,Date date_end, int number_entrant) throws SQLException {
        Event event = new Event(label, date_start, date_end, number_entrant);
        boolean state = this.eventDao.insert(event, this.team.getName());

        if (state) {
            // If the insert is ok, we get the id given by the database and add it to the java object before inserted it in the arrayList
            int idE = (int) this.eventDao.selectLast().getObject("event_id");
            event.setIdE(idE);
            this.eventList.add(event);
        }
        return state;
    }

    /**
     * @return
     */
    public ArrayList<Event> getAllEvent() {
        return this.eventList;
    }

    /**
     * @param idE 
     * @return
     */
    public boolean deleteEvent(int idE) throws SQLException {
        // idE is the index of the event in the arrayList
        boolean state = this.eventDao.delete(this.eventList.get(idE).getIdE(), this.team.getName());
        if (state){
            this.eventList.remove(idE);
        }
        return state;
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
        //idE is the index of the event in the arrayList
        boolean state = this.eventDao.update(this.eventList.get(idE).getIdE(), label, date_start, date_end, number_entrant, this.team.getName());
        if (state){
            this.eventList.get(idE).setLabel(label);
            this.eventList.get(idE).setDateStart(date_start);
            this.eventList.get(idE).setDateEnd(date_end);
            this.eventList.get(idE).setNumberEntrant(number_entrant);
        }
        return state;
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
        this.contactDao.deleteLink(idE, idC);
        return false;
    }

    /**
     * @param idE 
     * @return
     */
    public ArrayList getAllContactForEvent(int idE) {
        ResultSet result = this.contactDao.selectAll();
        return null;
    }

}