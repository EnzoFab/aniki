package business_logic;

import java.util.*;



/**
 *  Transaction can be created for events or for teams
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



    private String paymentmethod;

    /**
     * 
     */
    private Date date;

    /**
     * 
     */
    private String receipt;

    /**
     *
     * @param label
     * @param amount
     * @param date
     * @param state
     * @param type
     *
     */
    public Transaction(String label, int amount, Date date, int state, String type) {

        this.label = label;
        this.amount = amount;
        this.state = state;
        this.date = date;
        this.type = type;
        this.date = date;

    }

    /**
     *
     * @return int idTransaction
     */
    public int getIdT() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setIdT(int id) {
        this.id = id;
    }

    /**
     *
     * @return String label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return Int amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     *
     * @return int state
     */
    public int getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     *
     * @return string type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return Date date
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return string receipt
     */
    public String getReceipt() {
        return receipt;
    }

    /**
     *
     * @param receipt
     */
    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    /**
     *
     * @return string Paymentmethod
     */
    public String getPaymentmethod() {
        return paymentmethod;
    }

    /**
     *
     * @param paymentmethod
     */
    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }
}