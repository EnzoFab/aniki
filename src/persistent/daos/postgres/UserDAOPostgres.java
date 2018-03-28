package persistent.daos.postgres;

import business_logic.User;
import persistent.daos.UserDAO;

import java.sql.*;
import java.util.ArrayList;

/**
 * 
 */
public class UserDAOPostgres extends UserDAO {


    public UserDAOPostgres(Connection c) {
        super(c);
    }

    @Override
    public boolean insert(User user) {
        String preparedQuery =
                "INSERT INTO anikiuser (user_mail,user_name,user_first_name,user_password,user_phone) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = getConnection().prepareStatement(preparedQuery);
            ps.setString(1,user.getMail());
            ps.setString(2,user.getName());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getPassword());
            ps.setString(5,user.getPhone());
            ps.execute(); // execute the prepared query

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public ResultSet select(String mail) {
        Connection connect = getConnection();
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
           ResultSet set =  state.executeQuery("SELECT * FROM anikiuser U WHERE U.user_mail='"+mail+"'");
           if(set.first())
               return set;
           else return  null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public boolean update(String mail, String firstName, String name, String pwd, String phone) {
        Connection connect = getConnection();
        // create our java preparedstatement using a sql update query
        PreparedStatement ps = null;
        try {
            ps = connect.prepareStatement(
                    "UPDATE anikiuser SET user_first_name = ?, user_name = ?, user_password = ?, user_phone = ?  WHERE user_mail = ? ");
            // set the preparedstatement parameters
            ps.setString(1,firstName);
            ps.setString(2,name);
            ps.setString(3,pwd);
            ps.setString(4,phone);
            ps.setString(5,mail);
            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ResultSet selectByTeam(String idTeam) {
        return null;
    }

    @Override
    public boolean delete(String mail) {
        return false;
    }

    @Override
    public ResultSet selectAll() {
        return null;
    }
}