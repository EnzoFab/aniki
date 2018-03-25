package business_logic;

import java.util.*;

/**
 * 
 */
public class ToDoList {



    /**
     * 
     */
    public int idTD;

    /**
     * 
     */
    private String label;

    public ToDoList(int idTD, String label) {
        this.idTD = idTD;
        this.label = label;
    }

    public int getIdTD() {
        return idTD;
    }

    public void setIdTD(int idTD) {
        this.idTD = idTD;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}