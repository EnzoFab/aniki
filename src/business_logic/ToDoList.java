package business_logic;

import java.util.ArrayList;

public class ToDoList {

    private String label;

    private Event event;
    private ArrayList<Task> tasks;

    public ToDoList (String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Event getEvent() {
        return event;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
