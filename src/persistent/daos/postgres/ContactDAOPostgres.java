package persistent.daos.postgres;

import persistent.daos.ContactDAO;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * 
 */
public class ContactDAOPostgres extends ContactDAO {


    public ContactDAOPostgres(Connection connection) {
        super(connection);
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }

    @Override
    public ResultSet selectAll(String team) {
        return null;
    }

    @Override
    public boolean deleteAssocationEvent(String contact, String event) {
        return false;
    }

    @Override
    public boolean update(String name, String place, String phone, String mail) {
        return false;
    }
}