package business_logic;


import java.util.*;

/**
 * 
 */
public class Budget {
    /**
     *
     */
    private int Amount;

    private int event;

    private String team;

    private String anualBudget;

    private ArrayList transactions;

    /**
     * Default constructor
     * @param amount
     */

    public Budget(int amount, String anual) {
        Amount = amount;
        this.anualBudget = anual;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getEvent(){
        return this.event;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public String getAnualBudget() {
        return anualBudget;
    }

    public void setAnualBudget(String anualBudget) {
        this.anualBudget = anualBudget;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public ArrayList getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList transactions) {
        this.transactions = transactions;
    }
}