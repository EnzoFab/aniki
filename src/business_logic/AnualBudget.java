package business_logic;

import java.util.ArrayList;

public class AnualBudget {

    private int amount;
    private int year;
    private String listName;
    private ArrayList listTranstaction;

    public AnualBudget (int amount, int year, String listName){
        this.amount = amount;
        this.year = year;
        this.listName = listName;
        listTranstaction = new ArrayList();
    }

    public int getAmount() {
        return amount;
    }

    public int getYear() {
        return year;
    }

    public String getListName() {
        return listName;
    }

    public int balance(){
        return 0;
    }

}
