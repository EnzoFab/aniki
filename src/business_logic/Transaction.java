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
    private String state;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Date transaction;

    /**
     * 
     */
    private String receipt;

    public Transaction( int id, String label, int amount,
                       String state, String type, Date transaction, String receipt) {

        this.id = id;
        this.label = label;
        this.amount = amount;
        this.state = state;
        this.transaction = transaction;
        this.type = type;
        this.receipt = receipt;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTransaction() {
        return transaction;
    }

    public void setTransaction(Date transaction) {
        this.transaction = transaction;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }
}