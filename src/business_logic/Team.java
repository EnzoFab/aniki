package business_logic;

import java.util.*;

/**
 * 
 */
public class Team {

    /**
     * 
     */
    private String name;
    private ArrayList<User> teamMembers;
    private Budget budget;
    private ArrayList<Contact> contacts;

    public Team(String name) {
        this.name = name;
        teamMembers = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }


    public String toString(){
        return this.name;
    }
}