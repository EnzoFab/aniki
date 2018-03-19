package persistent.daos;

import business_logic.Team;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class TeamDAO extends DAO {

    /**
     * Default constructor
     */
    public TeamDAO(Connection c) {
        super(c);
    }


    /**
     * @param  idTeam
     * @param  userMail
     * @return
     */
    public abstract Team addUser(String idTeam, String userMail);

    /**
     * @param  id
     * @return
     */
    public abstract Team findTeamById( String id);

    /**
     * @param  param
     * @return
     */
    public abstract boolean insert( String ...param);

    /**
     * @param  userMail
     * @return
     */
    public abstract ArrayList getAllTeamforUser( String userMail);

    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}