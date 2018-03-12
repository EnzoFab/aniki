package persistent.daos;

import business_logic.User;
import persistent.daos.UserDao;

import java.sql.*;

public class UserDaoPostgres extends UserDao {
    public UserDaoPostgres(Connection c){
        super(c);
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public User create(String mail, String pwd) {
        return null;
    }

    @Override
    public User getUserById(String mail) {
        Connection connect = getConnect();
        User user=null;
        try {
            Statement state = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_FORWARD_ONLY);
            ResultSet result = state.executeQuery("SELECT * FROM anikiuser U WHERE U.user_mail='"+mail+"'");
            if(result.first())
                user = new User(mail, result.getString("user_first_name"),
                        result.getString("user_name"), result.getString("user_password"), result.getString("user_phone"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
