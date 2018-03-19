package persistent.daos;

import business_logic.Role;

import java.sql.Connection;

/**
 * 
 */
public abstract class RoleDAO extends DAO {

    /**
     * Default constructor
     */
    public RoleDAO(Connection c) {
        super(c);
    }



    /**
     * @param  userMail
     * @param  teamId
     * @return
     */
    public abstract Role getUserRole(String userMail, String teamId);

    /**
     * @param  id
     * @return
     */
    public abstract void deleteByID( String id);

}