package business_logic;

import java.util.ArrayList;

public class PaymentMethod {

    private String label;

    private ArrayList<Transaction> transactions;

    public PaymentMethod (String label){
        this.label = label;
        transactions = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
