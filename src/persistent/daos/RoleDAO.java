package persistent.daos;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public abstract class RoleDAO extends DAO {


    public RoleDAO(Connection connection) {
        super(connection);
    }

    /**
     * @param mail 
     * @param team 
     * @param role 
     * @return
     */
    public abstract boolean insert(String mail, String team, String role);

    /**
     * @param user 
     * @param team 
     * @return
     */
    public abstract boolean delete(String user, String team);

}