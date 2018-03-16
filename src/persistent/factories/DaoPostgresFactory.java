package persistent.factories;

import persistent.daos.UserDao;
import persistent.daos.UserDaoPostgres;

public class DaoPostgresFactory extends DaoFactory{

    private DaoPostgresFactory(){
        super();
    }

    public static DaoFactory getInstance(){
        if(factory == null) {
            factory = new DaoPostgresFactory();
        }
        return factory;
    }

    @Override
    public UserDao createUserDao() {
        return new UserDaoPostgres(connect);
    }


}
