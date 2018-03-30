package facade;

import business_logic.User;

import java.util.*;

/**
 * 
 */
public class AllTeamFacade {

    private User connectedUser;
    /**
     * Default constructor
     */
    public AllTeamFacade(User user) {
        this.connectedUser = user ;
    }



    /**
     * @param team 
     * @return
     */
    public boolean exists(String team) {
        // TODO implement here
        return false;
    }

    /**
     * @param team 
     * @return
     */
    public String createTeam(String team) {
        // TODO implement here
        return "";
    }

    /**
     * @param team 
     * @return
     */
    public boolean deleteTeam(String team) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<String> getAllTeam() {
        // TODO implement here
        return null;
    }

}