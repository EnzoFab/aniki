package facade;

import business_logic.Team;
import business_logic.User;
import persistent.daos.TeamDAO;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class TeamFacade {
    TeamDAO teamDAO;

    /**
     * Default constructor
     * @param connectedUser
     */
    public TeamFacade(User connectedUser) {
        teamDAO = DaoPostgresFactory.getInstance().createTeamDAO();
    }

    /**
     * 
     */
    private Team tean;




    /**
     * @param mail 
     * @param role 
     * @return
     */
    public boolean addMember(String mail, String role) {
        // TODO implement here
        return false;
    }

    /**
     * @param mail 
     * @return
     */
    public boolean deleteMember(String mail) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<String> getMembers() {
        // TODO implement here
        return null;
    }

    /**
     * @param role 
     * @param mail 
     * @return
     */
    public boolean changeRole(String role, String mail) {
        // TODO implement here
        return false;
    }

    /**
     * @param team
     */
    public void TeamFacade(String team) {
        // TODO implement here
    }

    public ArrayList<String> getAllTeam() throws SQLException {
        ResultSet team = teamDAO.selectAll();
        ArrayList<String> teamName = new ArrayList<>();
        while(team.next()){
            teamName.add(team.getString("team_name"));
        }
        return teamName;
    }
}