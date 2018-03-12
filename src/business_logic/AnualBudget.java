package business_logic;

public class AnualBudget {

    private int amount;
    private int year;
    private String listName;

    public AnualBudget (int amount, int year, String listName){
        this.amount = amount;
        this.year = year;
        this.listName = listName;
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
