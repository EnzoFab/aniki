package business_logic;

import java.util.ArrayList;

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
    private String first_name;

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

    private ArrayList<String> teamList;

    public Contact(){

    }

    public Contact(String name, String first_name, String place, String mail, String phone) {
        //this.idC = idC;
        this.name = name;
        this.first_name = first_name;
        this.place = place;
        this.phoneNumber = phone;
        this.mail = mail;
        this.teamList = new ArrayList<>();
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

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
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

    public ArrayList<String> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<String> teamList) {
        this.teamList = teamList;
    }
}