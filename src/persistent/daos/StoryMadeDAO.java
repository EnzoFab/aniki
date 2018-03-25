package persistent.daos;

import business_logic.StoryMade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public abstract class StoryMadeDAO extends DAO {


    public StoryMadeDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param story 
     * @return
     */
    public abstract boolean insert(StoryMade story) ;

    /**
     * @param story 
     * @return
     */
    public abstract boolean delete(StoryMade story) ;
    /**
     * @return
     */
    public abstract ResultSet selectAll();
}