package business_logic;

import java.util.*;

/**
 * 
 */
public class AnualBudget {

    /**
     * 
     */
    private int amount;

    /**
     * 
     */
    private int year;

    /**
     * 
     */
    private String listname;
    private ArrayList listTranstaction;

    public AnualBudget(int amount, int year, String listname, ArrayList listTranstaction) {
        this.amount = amount;
        this.year = year;
        this.listname = listname;
        this.listTranstaction = listTranstaction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public ArrayList getListTranstaction() {
        return listTranstaction;
    }

    public void setListTranstaction(ArrayList listTranstaction) {
        this.listTranstaction = listTranstaction;
    }
}