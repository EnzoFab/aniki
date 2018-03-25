package business_logic;

import java.util.*;

/**
 * 
 */
public class Task {
    /**
     *
     */
    private int idTa;

    /**
     *
     */
    private boolean state;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Date date;

    public Task(int idTa, boolean state, String name, Date date) {
        this.idTa = idTa;
        this.state = state;
        this.name = name;
        this.date = date;
    }

    public int getIdTa() {
        return idTa;
    }

    public void setIdTa(int idTa) {
        this.idTa = idTa;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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
}