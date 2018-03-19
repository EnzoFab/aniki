package persistent.daos.postgre;

import business_logic.Role;
import helpers.Couple;
import persistent.daos.RoleDAO;

import java.sql.Connection;

public class RoleDAOPostgres extends RoleDAO {

    /**
     * Default constructor
     *
     * @param c
     */
    public RoleDAOPostgres(Connection c) {
        super(c);
    }

    @Override
    public Role getUserRole(String userMail, String teamId) {
        return null;
    }

    @Override
    public void deleteByID(String id) {

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
}
