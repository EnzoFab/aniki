package business_logic;

import java.util.ArrayList;

public class Budget {

    private int amount;

    private Team team;

    private ArrayList transactions;

    public Budget (int amount, Team team){
        this.amount = amount;
        transactions = new ArrayList();
        this.team = team;

    }

    public int getAmount() {
        return amount;
    }

    public Team getTeam() {
        return team;
    }

    public ArrayList getTransactions() {
        return transactions;
    }


    public int balance(){
        return 0;
    }
}
