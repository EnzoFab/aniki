package persistent.factories;

import persistent.daos.*;
import persistent.daos.postgres.AnualBudgetDAOPostgres;
import persistent.daos.postgres.EventDAOPostgres;
import persistent.daos.postgres.UserDAOPostgres;


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
    public TeamDAO createTeamDAO() {
        return null;
    }

    @Override
    public ToDoListDAO createTodoListDAO() {
        return null;
    }

    @Override
    public EventDAO createEventDAO() {
        EventDAOPostgres eventDao = new EventDAOPostgres(this.connect);
        return eventDao;
    }

    @Override
    public TaskDAO createTaskDAO() {
        return null;
    }

    @Override
    public TransactionDAO createTransactionDAO() {
        return null;
    }

    @Override
    public ArticleDAO createArticleDAO() {
        return null;
    }

    @Override
    public StoryMadeDAO createStoryMadeDAO() {
        return null;
    }

    @Override
    public AnualBudgetDAO createAnualBudgetDAO() {
        return new AnualBudgetDAOPostgres(connect);
    }

    @Override
    public ContactDAO createContactDAO() {
        return null;
    }

    @Override
    public RoleDAO createRoleDAO() {
        return null;
    }

    @Override
    public UserDAO createUserDAO() {
        return new UserDAOPostgres(connect);
    }


}
