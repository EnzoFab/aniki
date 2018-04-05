package facade;

import business_logic.LightUser;
import business_logic.User;
import persistent.daos.UserDAO;
import persistent.factories.DaoPostgresFactory;

import java.util.*;

/**
 * Make the link between view, buisiness logic and persistent data that deals with users
 */
public class UserFacade {
    private User connectedUser;
    private UserDAO dao;

    /**
     * Default constructor
     */
    public UserFacade(User usr) {
        this.connectedUser = usr;
        dao = DaoPostgresFactory.getInstance().createUserDAO();
    }


    /**
     *Try to create a new user return true if it's done successfully
     * @param mail
     * @param fn
     * @param name
     * @param pwd
     * @param phone
     * @return
     */
    public boolean create(String mail, String fn, String name, String pwd, String phone) {
        User user = new User(mail,name,fn,pwd, phone);
       return dao.insert(user);

    }

    /**
     * Try to update and user
     * @param mail 
     * @param firsName 
     * @param name
     * @param phone 
     * @return
     */
    public boolean update(String mail, String firsName, String name, String phone) {
        if(dao.update(mail,firsName,name,connectedUser.getPassword(),phone)){
            connectedUser.setFirstName(firsName);
            connectedUser.setName(name);
            connectedUser.setPhone(phone);
            return true;
        }
        return false;
    }

    /**
     * Try to update the password of the user
     * @param mail
     * @param pwd
     * @return
     */
    public boolean updatePwd(String mail, String pwd){
        if(dao.update(mail, connectedUser.getFirstName(),connectedUser.getName(),pwd,
                connectedUser.getPhone())){
            connectedUser.setPassword(pwd);
            return true;
        }
        return false;
    }

    /**
     * @param mail 
     * @return
     */
    public boolean delete(String mail) {
        // TODO implement here
        return false;
    }

    /**
     * Return an ArrayList of LightUser representing all the user in the database
     * @return
     */
    public ArrayList<LightUser> getAll() {
        // TODO implement here
        return null;
    }

    /**
     * return true if the paramater match the password of the user currently connected
     * @param pwd
     * @return
     */
    public boolean checkPwd(String pwd){
        return connectedUser.getPassword().equals(pwd) ;
    }

    /**
     *
     * @return
     */
    public LightUser getLightUser(){
        return this.connectedUser;
    }

}