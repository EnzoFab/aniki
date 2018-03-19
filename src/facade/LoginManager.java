package facade;

import business_logic.User;
import helpers.MailSender;
import persistent.daos.UserDAO;
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

        UserDAO dao = factory.createUserDAO();
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
        UserDAO dao = factory.createUserDAO();
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

    /*/**
     * Reset the user password and send the new one by mail
     * @param mail
     * @see Couple
     * @return
     */
    /*public boolean resetPwd(String mail){
        boolean result = false;
        String newPasswordValue = ""; // change the password
        if(factory.createUserDao().update(mail, new Couple("password",newPasswordValue)) ){
            // essaie de mettre a jour le mail mot de passe de l'utilisateur si c'est ok on l'envoie par mail
            String content = "<img src='media/img/logo-aniki.png'/><p>" +
                    "Your password has been update to: <i>" + newPasswordValue+"</i></p><b>Don't lose it ;) </b>";
            return MailSender.sendHtmlMail(mail,"aniki","New password",content);
        }
        return  result;
    }*/



    public boolean forgotPwd(String mail){
        User user = factory.createUserDAO().getUserById(mail);
        if(user != null){
            String content = "<img src='media/img/logo-aniki.png'/><p>" +
                    "Your best friend has found this for you: <i>" + user.getPassword()+"</i></p><b>Use it wisely </b>";
            return MailSender.sendHtmlMail(mail,"aniki","Password",content);
        }else{
            return false;
        }
    }







}
