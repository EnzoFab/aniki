package persistent.daos.postgres;

import business_logic.Team;
import persistent.daos.TeamDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class TeamDAOPostgres extends TeamDAO {


    public TeamDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public ResultSet selectAll() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM team");
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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