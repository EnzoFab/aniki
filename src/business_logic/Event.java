package business_logic;

import java.util.ArrayList;
import java.util.Date;

public class Event {

    private String name;
    private Date date;

    private ArrayList<StoryMade> storyMade;

    private ArrayList<String> attendents;
    private ArrayList<Transaction> transaction;
    private ArrayList<ToDoList> todolists;

    public Event (String name, Date date, ArrayList<String> attendents){
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<String> getAttendents() {
        return attendents;
    }

    public ArrayList<Transaction> getTransaction() {
        return transaction;
    }

    public ArrayList<StoryMade> getStoryMade() {
        return storyMade;
    }

    public ArrayList<ToDoList> getTodolists() {
        return todolists;
    }
}
