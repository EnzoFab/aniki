package business_logic;

import java.util.*;

/**
 * 
 */
public class Transaction {

    private Budget budget;
    private Event event;


    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String label;

    /**
     * 
     */
    private int amount;

    /**
     * 
     */
    private int state;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String receipt;

    public Transaction(String label, int amount, Date date, int state, String type) {

        this.label = label;
        this.amount = amount;
        this.state = state;
        this.date = date;
        this.type = type;
        this.date = date;

    }


    public int getIdT() {
        return id;
    }

    public void setIdT(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}