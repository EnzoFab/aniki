package persistent.daos.postgres;

import business_logic.Team;
import persistent.daos.TeamDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public class TeamDAOPostgres extends TeamDAO {


    public TeamDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }

    @Override
    public ResultSet select(String team) {
        return null;
    }

    @Override
    public boolean insert(Team team) {
        return false;
    }

    @Override
    public boolean delete(String team) {
        return false;
    }


}