package business_logic;

import java.util.*;

/**
 * 
 */
public class StoryMade {

    /**
     *
     */
    private final int idS;

    /**
     *
     */
    private String label;

    /**
     *
     */
    private Date date;

    /**
     *
     */
    private String text;


    public StoryMade(int idS, String label, Date date, String text) {
        this.idS = idS;
        this.label = label;
        this.date = date;
        this.text = text;
    }


    public int getIdS() {
        return idS;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}