package persistent.daos;

import business_logic.Team;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * 
 */
public abstract class TeamDAO  extends DAO{


    public TeamDAO(Connection connection) {
        super(connection);
    }

    /**
     * @return
     */
    public abstract ResultSet selectAll();
    /**
     * @param team 
     * @return
     */
    public abstract ResultSet select(String team) ;

    /**
     * @param team 
     * @return
     */
    public abstract boolean insert(Team team) ;

    /**
     * @param team 
     * @return
     */
    public abstract boolean delete(String team) ;
}