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

    /**
     * Called when an User is trying to connect to the Application
     * uses the factory to create a DaoUser and the use the method provided
     * @param mail
     * @param pwd
     * @return
     */
    public boolean login(String mail, String pwd){
        boolean egal=false;
        UserDao dao = factory.createUserDao();
        user = dao.getUserById(mail);
        if(user !=null && user.getPassword()==pwd){
            egal=true;
            System.out.println("heu");
        }

        return egal;
    }

    public String getUserName(){
        return "";
    }




}
