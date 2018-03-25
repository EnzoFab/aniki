package business_logic;

import java.util.*;

/**
 * 
 */
public class Contact {

    /**
     * 
     */
    private int idC;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String place;

    /**
     * 
     */
    private String phoneNumber;

    /**
     * 
     */
    private String mail;

    public Contact(int idC, String name, String place, String phoneNumber, String mail) {
        this.idC = idC;
        this.name = name;
        this.place = place;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}