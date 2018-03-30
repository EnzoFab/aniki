package persistent.factories;

import persistent.daos.*;
import persistent.daos.postgres.*;


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
    public TeamDAO createTeamDAO(){
        return new TeamDAOPostgres((this.connect));
    }

    public PaymentMethodDAO createPaymentMethodDAO() {
        PaymentMethodDAOPostgres paymentMethodDAO = new PaymentMethodDAOPostgres(this.connect);
        return paymentMethodDAO;    }


    @Override
    public ToDoListDAO createTodoListDAO() {
        return null;
    }

    @Override
    public BudgetDAO createBudgetDAO() {
        return new BudgetDAOPostgres(this.connect);
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
        TransactionDAOPostgres transactionDao = new TransactionDAOPostgres(this.connect);
        return transactionDao;
    }

    @Override
    public ArticleDAO createArticleDAO() {
        ArticleDAO articleDao = new ArticleDAOPostgres(this.connect);
        return articleDao;
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
        ContactDAOPostgres contactDao = new ContactDAOPostgres(this.connect);
        return contactDao;
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
