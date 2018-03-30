package facade;

import business_logic.AnualBudget;
import business_logic.Budget;
import persistent.daos.*;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */
public class BudgetFacade {

    private BudgetDAO budgetDAO;
    private AnualBudgetDAO anualBudgetDAO;
    private TransactionDAO transactionDAO;
    private ArrayList<Budget> listBudget;
    private EventDAO eventDAO;
    private TeamDAO teamDAO;
    /**
     * Default constructor
     */
    public BudgetFacade() {
        this.budgetDAO = DaoPostgresFactory.getInstance().createBudgetDAO();
        this.anualBudgetDAO = DaoPostgresFactory.getInstance().createAnualBudgetDAO();
        this.transactionDAO = DaoPostgresFactory.getInstance().createTransactionDAO();
        this.eventDAO = DaoPostgresFactory.getInstance().createEventDAO();
        this.teamDAO = DaoPostgresFactory.getInstance().createTeamDAO();
    }

    /**
     * 
     */
    public AnualBudget anual;

    /**
     * @param amount
     * @return
     */
    public boolean allocateNewBudget(int amount, String event){
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public int leftAnualBudget() {
        // TODO implement here
        return 0;
    }

    /**
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

    public ArrayList<String> getEventLeft() throws SQLException {
        System.out.println("heu");
        ResultSet setBudget = budgetDAO.selectAll();
        ResultSet setEvent = eventDAO.selectAll();
        ArrayList<String> listIdEvent = new ArrayList<>();
        ArrayList<String> listIdEventFromBudget = new ArrayList<>();

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

    public ArrayList<String> getTeam() throws SQLException {
        ResultSet team = teamDAO.selectAll();
        ArrayList<String> eventName = new ArrayList<>();
        while(team.next()){
            eventName.add(team.getString("team_name"));
        }
        return eventName;
    }
}