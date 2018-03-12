package facade;

import business_logic.User;
import persistent.daos.UserDao;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

public class LoginManager {
    private User user;
    private DaoFactory factory;

    public LoginManager() {
        user = null;
        factory = new DaoPostgresFactory();
    }

    public User login(String mail, String pwd){
        UserDao dao = factory.createUserDao();
        user =dao.create(mail,pwd);
        return user ;
    }

    public String getUserName(){
        return "";
    }




}
