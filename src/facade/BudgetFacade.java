package facade;

import business_logic.AnualBudget;
import business_logic.Budget;
import business_logic.Team;
import business_logic.Transaction;
import persistent.daos.AnualBudgetDAO;
import persistent.daos.BudgetDAO;
import persistent.daos.EventDAO;
import persistent.daos.TransactionDAO;
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
    private Team team;
    /**
     * Default constructor
     */
    public BudgetFacade() {
        this.budgetDAO = DaoPostgresFactory.getInstance().createBudgetDAO();
        this.anualBudgetDAO = DaoPostgresFactory.getInstance().createAnualBudgetDAO();
        this.transactionDAO = DaoPostgresFactory.getInstance().createTransactionDAO();
        this.eventDAO = DaoPostgresFactory.getInstance().createEventDAO();
    }

    /**
     * 
     */
    public AnualBudget anual;

    /**
     * @param team 
     * @param amount 
     * @return
     */
    public boolean allocateNewBudget(int amount) {
        // TODO implement here
        Budget b = new Budget(amount, this.team);
        boolean state = this.budgetDAO.insert(b);
        if (state) {
            this.listBudget.add(b);
        }
        return state;
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
        ResultSet event = eventDAO.getEventWithoutBudget();
        ArrayList<String> eventName = new ArrayList<>();
        while(event.next()){
            eventName.add(event.getString("event_label"));
        }
        return eventName;
    }
}