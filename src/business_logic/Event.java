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
    private String label;

    /**
     *
     */
    private Date date_start;
    private Date date_end;

    /**
     *
     */
    private int number_entrant;


    public Event(String label, Date date_start,Date date_end, int number_entrant) {
        //this.idE = idE;
        this.label = label;
        this.date_start = date_start;
        this.date_end = date_end;
        this.number_entrant = number_entrant;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String name) {
        this.label = name;
    }

    public Date getDateStart() {
        return date_start;
    }

    public void setDateStart(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDateEnd() {
        return date_end;
    }

    public void setDateEnd(Date date_end) {
        this.date_end = date_end;
    }

    public int getNumberEntrant() {
        return number_entrant;
    }

    public void setNumberEntrant(int number_entrant) {
        this.number_entrant = number_entrant;
    }
}