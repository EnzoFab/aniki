package facade;

import helpers.Couple;
import business_logic.User;
import helpers.MailSender;
import persistent.daos.UserDao;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

public class LoginManager {
    private User user;
    private final DaoFactory factory;

    public LoginManager() {
        user = null;
        factory = DaoPostgresFactory.getInstance();
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

        UserDao dao = factory.createUserDao();
        user = dao.getUserById(mail);
        if(user ==null )
            result="Error";
        else if(user.getPassword().equals(pwd))
            result = "Success";
        else{
            result= "Failed" ;
        }
        return result;
    }

    public boolean exists(String mail){
        UserDao dao = factory.createUserDao();
        return dao.getUserById(mail) != null;

    }

    public String getUserName(){
        if(user != null)
            return user.getName();
        return "";
    }

    public String getUserFirstName(){
        if(user !=null)
            return user.getFirstName();
        return "";
    }

    /**
     * Reset the user password and send the new one by mail
     * @param mail
     * @return
     */
    public boolean resetPwd(String mail){
        boolean result = false;
        String newPasswordValue = ""; // change the password
        if(factory.createUserDao().update(mail, new Couple("password",newPasswordValue)) ){
            String content = "<img src='media/img/logo-aniki.png'/><p>" +
                    "Your password has been update to: <i>" + newPasswordValue+"</i></p><b>Don't lose it ;) </b>";
            return MailSender.sendHtmlMail(mail,"aniki","New password",content);
        }
        return  result;
    }











}
