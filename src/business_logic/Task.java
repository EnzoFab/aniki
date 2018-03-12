package business_logic;

import java.util.Date;

public class Task {

    private Boolean state;
    private String name;
    private Date date;

    private ToDoList todolist;

    public Task (Boolean state, String name, Date date){
        this.state = state;
        this.name = name;
        this.date = date;
    }

    public Boolean getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public ToDoList getTodolist() {
        return todolist;
    }
}
