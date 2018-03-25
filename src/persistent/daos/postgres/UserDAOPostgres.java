package persistent.daos.postgres;

import business_logic.User;
import persistent.daos.UserDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return false;
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