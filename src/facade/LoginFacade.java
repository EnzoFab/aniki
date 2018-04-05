package facade;

import business_logic.User;
import helpers.MailSender;
import persistent.daos.UserDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This facade link the login View and the Database, to check for the login or the creation of a new user.
 */
public class LoginFacade {
    private User user;
    private final DaoFactory factory;
    private FacadeManager facadeManager;

    public LoginFacade() {
        user = null;
        factory = DaoPostgresFactory.getInstance();
        facadeManager = null;
    }

    /**
     * Called when an User is trying to connect to the Application
     * uses the factory to insert a DaoUser and the use the method provided
     * @param mail
     * @param pwd
     * @return
     */
    public String login(String mail, String pwd){
        String result;

        UserDAO dao = factory.createUserDAO();
        ResultSet resultSet = dao.select(mail);
        if(resultSet == null){
            result="Failed";
        }else{
            try {
                user = new User(mail, resultSet.getString("user_first_name"),
                        resultSet.getString("user_name"), resultSet.getString("user_password"), resultSet.getString("user_phone"));
                facadeManager = new FacadeManager(user); // create facade manager
            } catch (SQLException e) {
                e.printStackTrace();
                result ="Error";
            }
            if(user.getPassword().equals(pwd))
                result = "Success";
            else{
                result= "Failed" ;
            }
        }


        return result;
    }

    /**
     * Check if the user exists
     * @param mail
     * @return
     */
    public boolean exists(String mail){
        UserDAO dao = factory.createUserDAO();
        return dao.select(mail) != null;

    }

    /**
     * Return the facade manager
     * @see FacadeManager
     * @return
     */
    public FacadeManager getFacadeManager() {
        return facadeManager;
    }


    /**
     * Send by mail the password of the user that math the mail given in parameter
     * if there is a user that have the same mail as the parameter and  the mail is sent with success
     * return true, otherwise return false and catch the error
     * @see MailSender
     * @param mail
     * @return
     */
    public boolean forgotPwd(String mail){
        ResultSet resultSet = factory.createUserDAO().select(mail);
        if(resultSet != null){
            try {
                User user = new User(mail, resultSet.getString("user_first_name"),
                        resultSet.getString("user_name"), resultSet.getString("user_password"),
                        resultSet.getString("user_phone"));
                String content = "<img src='media/img/logo-aniki.png'/><p>" +
                        "Your best friend has found this for you: <i>" + user.getPassword()+"</i></p><b>Use it wisely </b>";
                return MailSender.sendHtmlMail(mail,"aniki","Password",content);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }


        }else{
            return false;
        }
    }







}
