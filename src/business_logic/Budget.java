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

    private String event;

    private ArrayList transactions;

    /**
     * Default constructor
     * @param amount
     */

    public Budget(int amount, String event) {
        Amount = amount;
        this.event = event;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getEvent(){
        return this.event;
    }

    public ArrayList getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList transactions) {
        this.transactions = transactions;
    }
}