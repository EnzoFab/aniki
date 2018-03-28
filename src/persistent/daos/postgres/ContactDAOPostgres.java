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

    public boolean insert(String name, String place, String phoneNumber, String mail){
        return false;
    }

    public boolean insertLink(int idE, int idC){
        return false;
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }

    @Override
    public ResultSet selectAll(String team) {
        return null;
    }

    public ResultSet select(int contactId) {
        // TODO implement here
        return null;
    }

    public boolean deleteLink(int idE, int idC){
        return false;
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