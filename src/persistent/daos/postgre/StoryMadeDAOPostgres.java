package persistent.daos.postgre;

import helpers.Couple;
import persistent.daos.StoryMadeDAO;

import java.sql.Connection;

public class StoryMadeDAOPostgres extends StoryMadeDAO {

    /**
     * Default constructor
     *
     * @param c
     */
    public StoryMadeDAOPostgres(Connection c) {
        super(c);
    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public boolean insert(String... param) {
        return false;
    }

    @Override
    public boolean update(String mail, Couple... setData) {
        return false;
    }
}
