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

    public boolean login(String mail, String pwd){
        boolean egal=false;
        UserDao dao = factory.createUserDao();
        user = dao.getUserById(mail);
        if(user.getPassword()==pwd){
            egal=true;
            System.out.println("heu");
        }

        return egal;
    }

    public String getUserName(){
        return "";
    }




}
