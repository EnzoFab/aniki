package business_logic;

import java.util.*;

/**
 * 
 */
public class Event {
    private business_logic.Event event;

    /**
     *
     */
    private int idE;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Date date;

    /**
     *
     */
    private int capacity;


    public Event(int idE, String name, Date date, int capacity) {
        this.idE = idE;
        this.name = name;
        this.date = date;
        this.capacity = capacity;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}