package business_logic;

import java.util.ArrayList;

public class Budget {

    private int amount;

    private Team team;

    private ArrayList<Transaction> transactions;

    public Budget (int amount){
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Team getTeam() {
        return team;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
