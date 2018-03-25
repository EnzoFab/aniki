package persistent.daos.postgres;

import persistent.daos.RoleDAO;

import java.sql.Connection;
import java.util.*;

/**
 * 
 */
public class RoleDAOPostgres extends RoleDAO {


    public RoleDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public boolean insert(String mail, String team, String role) {
        return false;
    }

    @Override
    public boolean delete(String user, String team) {
        return false;
    }

}