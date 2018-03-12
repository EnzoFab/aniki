package persistent.factories;

import persistent.ConnectionDB;
import persistent.daos.UserDao;
import persistent.daos.UserDaoPostgres;

public class DaoPostgresFactory extends DaoFactory{

    public DaoPostgresFactory(){
        super.connect = ConnectionDB.getInstance();
    }

    @Override
    public UserDao createUserDao() {
        return new UserDaoPostgres(connect);
    }
}
