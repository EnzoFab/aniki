package persistent.daos.postgres;

import persistent.daos.ContactDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */
public class ContactDAOPostgres extends ContactDAO {


    public ContactDAOPostgres(Connection connection) {
        super(connection);
    }

    public boolean insert(String name, String first_name, String place, String mail, String phoneNumber){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("INSERT INTO contact (contact_name, contact_first_name, contact_adress, contact_mail, contact_phone) VALUES ('"+name+"', '"+first_name+"', '"+place+"', '"+mail+"', '"+phoneNumber+"')");
            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertLink(int idE, int idC){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("UPDATE contact SET event_id = '"+idE+"' WHERE contact_id == '"+idC+"'");
            if(set.first())
                return true;
            else return  false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ResultSet selectAll() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM contact");
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet selectAll(int idE) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM contact WHERE event_id == '"+idE+"'");
            if(set.first())
                return set;
            else return  null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet selectLast() {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("SELECT * FROM contact");
            if(set.last())
                return set;
            else return  null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet select(int contactId) {
        // TODO implement here
        return null;
    }

    public boolean deleteLink(int idE, int idC){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet set =  state.executeQuery("UPDATE contact SET event_id = 'null' WHERE contact_id == '"+idC+"' AND event_id =='"+idE+"'");
            if(set.first())
                return true;
            else return  false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int idC){
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("DELETE FROM contact WHERE contact_id = '"+idC+"'");
            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteAssocationEvent(String contact, String event) {
        return false;
    }

    @Override
    public boolean update(int idC, String name, String first_name, String place, String phone, String mail) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            int numberRowModified =  state.executeUpdate("UPDATE contact SET contact_name = '"+name+"', contact_first_name ='"+first_name+"', contact_adress = '"+place+"', contact_phone = '"+phone+"', contact_mail = '"+mail+"' WHERE contact_id = '"+idC+"'");

            return numberRowModified == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

