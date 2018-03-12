package business_logic;

import java.util.ArrayList;

public class Team {

    private String name;

    private ArrayList<User> teamMembers;
    private Budget budget;
    private ArrayList<Contact> contacts;

    public Team (String name){
        this.name = name;
        this.teamMembers = new ArrayList<>();
    }

    //Methods
    public String getName() {
        return name;
    }

    public ArrayList<User> getTeamMembers() {
        return teamMembers;
    }

    public Budget getBudget() {
        return budget;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
