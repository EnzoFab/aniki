package persistent.daos.postgres;

import business_logic.StoryMade;
import persistent.daos.StoryMadeDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public class StoryMadeDAOPostgres extends StoryMadeDAO {


    public StoryMadeDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(StoryMade story) {
        return false;
    }

    @Override
    public boolean delete(StoryMade story) {
        return false;
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }

}