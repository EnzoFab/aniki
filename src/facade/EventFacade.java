package facade;

import business_logic.Event;
import business_logic.Team;
import business_logic.User;
import persistent.daos.ContactDAO;
import persistent.daos.EventDAO;
import persistent.daos.TeamDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The event facade link the Event model to the Event from the database
 */
public class EventFacade {

    /**
     * attributes
     */
    private User connectedUser;
    private Team team;
    private  EventDAO eventDao;
    private  ContactDAO contactDao;
    private  TeamDAO teamDAO;
    private ArrayList<Event> eventList;
    private ArrayList<Team> teamList;

    /**
     *
     * @param team_name
     * @param user
     *
     */
    public EventFacade(String team_name, User user) {
        this.team = new Team(team_name);
        init(user);

    }

    /**
     *
     * @param user
     */
    public EventFacade(User user){
        init(user);
    }

    /**
     * Change the team name
     * @param team
     */
    public void setTeam(String team){
        this.team = new Team(team);
    }

    /**
     *
     * @param user
     */
    private void init(User user){
        // Initialize the Postgres Dao
        connectedUser = user;
        DaoFactory factory = DaoPostgresFactory.getInstance();
        this.eventDao = factory.createEventDAO();
        this.teamDAO = factory.createTeamDAO();
        this.contactDao = factory.createContactDAO();
        this.eventList = new ArrayList<>();
        this.teamList = new ArrayList<>();

        // Get all Events and Team from the Database into our local lists
        try {
            this.loadEvent();
            this.loadTeam();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param label
     * @param date_start
     * @param date_end
     * @param number_entrant
     * @return
     *
     * Add an event to the Database
     *
     */
    public Event addEvent(String label, Date date_start,Date date_end, int number_entrant, String team) throws SQLException {
        Event event = new Event(label, date_start, date_end, number_entrant);

        if (this.eventDao.insert(event, team)) {
            // If the insert is ok, we get the id given by the database and add it to the java object before inserted it in the arrayList
            int idE = (int) this.eventDao.selectLast().getObject("event_id");
            event.setIdE(idE);
            this.eventList.add(event);
            return event;
        }
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Event> getAllEvent() {
        return this.eventList;
    }

    /**
     * @return
     */
    public ArrayList<Team> getAllTeam(){
        return this.teamList;
    }

    /**
     * @param idE 
     * @return
     *
     * Delete an event from the Database
     *
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
     *
     * Update an event from the Database
     *
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
     *
     * Add a link between an event and a contact
     *
     */
    public boolean addLink(int idE, int idC) {
        return false;
    }

    /**
     * @param idE 
     * @param idC 
     * @return
     *
     * Delete a link between an event and a contact
     *
     */
    public boolean deleteLink(int idE, String idC) {
        this.contactDao.deleteLink(idE, idC);
        return false;
    }

    /**
     * @param idE 
     * @return
     *
     * Get all contact from a single event
     *
     */
    public ArrayList getAllContactForEvent(int idE) {
        ResultSet result = this.contactDao.selectAll();
        return null;
    }

    /**
     * Get all events from the Database
     *
     */
    public void loadEvent() throws SQLException {
        ResultSet result = this.eventDao.selectAll();
        Event event;
        if (result.first()) {
            event = new Event(result.getString("event_label"), result.getDate("event_date_start"), result.getDate("event_date_end"), result.getInt("event_number_entrant"));
            event.setIdE(result.getInt("event_id"));
            this.eventList.add(event);
            while(result.next()){
                event = new Event(result.getString("event_label"), result.getDate("event_date_start"), result.getDate("event_date_end"), result.getInt("event_number_entrant"));
                event.setIdE(result.getInt("event_id"));
                this.eventList.add(event);
            }
        }
    }

    /**
     * @return
     *
     * Get all teams from the Database
     *
     */
    private void loadTeam() throws SQLException {
        ResultSet result = this.teamDAO.selectAll();
        Team team;
        if (result.first()) {
            //team_name
            team = new Team(result.getString("team_name"));
            this.teamList.add(team);
            while(result.next()){
                team = new Team(result.getString("team_name"));
                this.teamList.add(team);
            }
        }
    }

    /**
     * @return
     */
    public ArrayList<Event> getEventList() {
        return eventList;
    }
}