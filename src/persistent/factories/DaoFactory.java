package persistent.factories;

import persistent.ConnectionDB;
import persistent.daos.*;


import java.sql.Connection;

/**
 * Singleton class uses to create a DaoObject
 */
public abstract class DaoFactory {

    protected final Connection connect;

    protected static DaoFactory factory=null;

    protected DaoFactory(){
        this.connect = ConnectionDB.getInstance();
    }

    /**
     * get the unique instance of DaoFactory
     * @return
     */
    public static DaoFactory getInstance(){
        return factory;
    }




    /**
     * @return
     */
    public abstract UserDAO createUserDAO();

    /**
     * @return
     */
    public abstract TeamDAO createTeamDAO();

    /**
     * @return
     */
    public abstract ToDoListDAO createTodoListDAO();

    /**
     * @return
     */
    public abstract BudgetDAO createBudgetDAO();

    /**
     * @return
     */
    public abstract EventDAO createEventDAO();

    /**
     * @return
     */
    public abstract TaskDAO createTaskDAO();

    public abstract PaymentMethodDAO createPaymentMethodDAO();

    /**
     * @return
     */
    public abstract TransactionDAO createTransactionDAO();

    /**
     * @return
     */
    public abstract ArticleDAO createArticleDAO();

    /**
     * @return
     */
    public abstract StoryMadeDAO createStoryMadeDAO();

    /**
     * @return
     */
    public abstract AnualBudgetDAO createAnualBudgetDAO();

    /**
     * @return
     */
    public abstract ContactDAO createContactDAO();

    /**
     * @return
     */
    public abstract RoleDAO createRoleDAO();

}
