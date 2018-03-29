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

    private Team team;

    private Event event;

    private ArrayList transactions;

    /**
     * Default constructor
     * @param amount
     * @param team
     */

    public Budget(int amount, Team team, Event event) {
        Amount = amount;
        this.event = event;
        this.team = team;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public ArrayList getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList transactions) {
        this.transactions = transactions;
    }
}