package facade;

import business_logic.AnualBudget;
import business_logic.Budget;
import business_logic.User;
import persistent.daos.*;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 
 */
public class BudgetFacade {
    private final User connectUser;
    private BudgetDAO budgetDAO;
    private AnualBudgetDAO anualBudgetDAO;
    private TransactionDAO transactionDAO;
    private ArrayList<Budget> listBudget;
    private EventDAO eventDAO;
    private TeamDAO teamDAO;
    /**
     *
     */
    private AnualBudget anual;


    /**
     * Default constructor
     * @param connectedUser
     */
    public BudgetFacade(User connectedUser) {
        this.connectUser = connectedUser;
        this.budgetDAO = DaoPostgresFactory.getInstance().createBudgetDAO();
        this.anualBudgetDAO = DaoPostgresFactory.getInstance().createAnualBudgetDAO();
        this.transactionDAO = DaoPostgresFactory.getInstance().createTransactionDAO();
        this.eventDAO = DaoPostgresFactory.getInstance().createEventDAO();
        this.teamDAO = DaoPostgresFactory.getInstance().createTeamDAO();
    }


    /**
     * @return
     */
    public int leftAnualBudget() {
        // TODO implement here
        return 0;
    }

    /**
     * update an amount from a budget, return true if it is a success
     * @param team 
     * @param amount 
     * @return
     */
    public boolean update(String team, int amount) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList getAllBudget() {
        // TODO implement here
        return null;
    }

    /**
     * @param team 
     * @return
     */
    public boolean deleteBudget(String team) {
        // TODO implement here
        return false;
    }

    /**
     * Return all the budget which do not have any event assigned
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getEventLeft() throws SQLException {
        //select all the event and the budget
        ResultSet setBudget = budgetDAO.selectAll();
        ResultSet setEvent = eventDAO.selectAll();
        ArrayList<String> listIdEvent = new ArrayList<>();
        ArrayList<String> listIdEventFromBudget = new ArrayList<>();
        //select the event which does not have a budget
        if(setBudget != null && setBudget.first()){
            while(setBudget.next()){
                listIdEventFromBudget.add(setBudget.getString("event_id"));
            }
            if(!listIdEventFromBudget.isEmpty()){
                while (setEvent.next()){
                    if(listIdEventFromBudget.contains(new String(setEvent.getString("event_id")))){
                        listIdEvent.add(setEvent.getString("event_label"));
                    }
                }
            }
        }
        else{
            while(setEvent.next()){
                listIdEvent.add(setEvent.getString("event_label"));
            }
        }

        return listIdEvent;
    }

    /**
     * Return all the team
     * @return
     * @throws SQLException
     */
    public ArrayList<String> getTeam() throws SQLException {
        ResultSet team = teamDAO.selectAll();
        ArrayList<String> eventName = new ArrayList<>();
        while(team.next()){
            eventName.add(team.getString("team_name"));
        }
        return eventName;
    }

    /**
     * create a budget with a team and an event, return true if it is a success
     * @param amount
     * @param s
     * @param t
     * @return
     * @throws SQLException
     */
    public boolean create(int amount, String s, String t) throws SQLException {
        //get the actual year
        Calendar calendrier;
        calendrier = Calendar.getInstance();
        String anneeEnCours = String.valueOf(calendrier.get(Calendar.YEAR));
        Budget b = new Budget(amount, anneeEnCours);
        ResultSet set = eventDAO.selectByNameWithoutB(s);
        int id = 0;
        if(set.first()){
            id = set.getInt("event_id");
        }
        b.setEvent(id);
        b.setTeam(t);
        boolean value = this.budgetDAO.insert(b);
        if(value){
            return true;
        }
        return false;
    }
}