package facade;

import business_logic.AnualBudget;
import persistent.daos.AnualBudgetDAO;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class AnualBudgetFacade {

    private AnualBudgetDAO anualBudgetDAO;
    private AnualBudget anualBudget;
    private ResultSet allTransaction;
    private ArrayList<AnualBudget> allAnualBudget;

    /**
     * Default constructor
     */
    public AnualBudgetFacade() {
        this.anualBudgetDAO = DaoPostgresFactory.getInstance().createAnualBudgetDAO();
    }





    /**
     * Create a annual budget
     * @param listName 
     * @param year 
     * @param amount 
     * @return
     */
    public boolean create(String listName, int year, int amount) {
        // TODO implement here
        AnualBudget anualB = new AnualBudget(amount, year, listName);
        boolean value = this.anualBudgetDAO.insert(anualB);
        if(value) {
            this.anualBudget = anualB;
            return true;
        }
        return false;
    }

    /**
     * update the amount for actual annual budget
     * @param listName 
     * @param amount
     * @return
     */
    public boolean update(String listName, int amount) {
        // TODO implement here
        Calendar calendrier;
        calendrier = Calendar.getInstance();
        int anneeEnCours = calendrier.get(Calendar.YEAR);
        if(this.anualBudgetDAO.update(listName, amount, String.valueOf(anneeEnCours))){
            return true;
        }
        return false;
    }

    /**
     * Return all the annual budget
     * @return
     * @throws SQLException
     */
    public ArrayList<Integer> getAll() throws SQLException {
        // TODO implement here
        ResultSet allAnualBudget = this.anualBudgetDAO.getAll();
        ArrayList<Integer> years = new ArrayList<>();
        while(allAnualBudget.next()){
            years.add(allAnualBudget.getInt("anualbudget_year"));
        }
        return years;
    }

    /**
     * delete an annual budget
     * @param year
     * @return
     */
    public boolean delete(int year) {
        // TODO implement here
        if(this.anualBudgetDAO.deleteByID(year)){
            return true;
        }
        return false;
    }

    /**
     * Return the annual budget from the year selected
     * @param year
     * @return
     */
    public int getAnulaBudgetFromYear(int year){
        ResultSet set = anualBudgetDAO.getAnualBudgetFromYear(year);
        int amount = 0;
        try{
            if (set.first()) {
                amount = Integer.parseInt(set.getString("anualbudget_amount"));
                this.anualBudget = new AnualBudget(amount, year, set.getString("anualbudget_listname"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

        return amount;
    }

    /**
     * get the list name from an annual budget
     * @return
     */
    public String getListName() {
        return anualBudget.getListname();
    }

}