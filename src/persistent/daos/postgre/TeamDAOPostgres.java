package persistent.daos.postgre;

import business_logic.Team;
import helpers.Couple;
import persistent.daos.TeamDAO;

import java.sql.Connection;
import java.util.ArrayList;

public class TeamDAOPostgres extends TeamDAO {

    /**
     * Default constructor
     *
     * @param c
     */
    public TeamDAOPostgres(Connection c) {
        super(c);
    }

    @Override
    public Team addUser(String idTeam, String userMail) {
        return null;
    }

    @Override
    public Team findTeamById(String id) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public boolean insert(String... param) {
        return false;
    }

    @Override
    public boolean update(String mail, Couple... setData) {
        return false;
    }

    @Override
    public ArrayList getAllTeamforUser(String userMail) {
        return null;
    }

    @Override
    public void deleteByID(String id) {

    }
}
