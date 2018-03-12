package business_logic;

import java.util.Date;

public class Transaction {

    private String label;
    private int amount;
    private Date date;
    private String state;
    private String type;

    private Budget budget;
    private PaymentMethod paymentMethod;
    private Event event;

    public Transaction (String label, int amount, Date date, String state, String type){
        this.label = label;
        this.amount = amount;
        this.date = date;
        this.state = state;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    private Budget getBudget() {
        return budget;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Event getEvent() {
        return event;
    }
}
