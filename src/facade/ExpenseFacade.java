package facade;

import business_logic.*;
import persistent.daos.AnualBudgetDAO;
import persistent.daos.BudgetDAO;
import persistent.daos.ContactDAO;
import persistent.daos.EventDAO;
import persistent.daos.TransactionDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 
 */
public class ExpenseFacade {
    private BudgetDAO budgetDAO;
    private AnualBudgetDAO anualBudgetDAO;
    private Transaction transaction;
    private TransactionDAO transactionDAO;
    private ResultSet allTransaction;
    private ArrayList<Transaction> transactionsList;
    /**
     * Default constructor
     */
    public ExpenseFacade() {
        this.transactionDAO = DaoPostgresFactory.getInstance().createTransactionDAO();
        this.anualBudgetDAO = DaoPostgresFactory.getInstance().createAnualBudgetDAO();
        this.budgetDAO = DaoPostgresFactory.getInstance().createBudgetDAO();

    }

    /**
     * @return
     */



    /**
     * 
     */
    private Budget budget;










    /**
     * @param amount  
     * @param label 
     * @param type 
     * @param date 
     * @return
     */
    public boolean addTransaction(int amount , String label, String type, Date date) {
        /*Transaction transaction = new Transaction(Budget budget,  Event event, int id, String label, int amount,
        String state, String type, Date transaction, String receipt)
        boolean value = this.transaction.insert();

        if(value) {
            this.transaction = transaction;
            System.out.println("OKAYY");
            return true;
        }*/
        return false;
    }

    /**
     * @param idT 
     * @return
     */
    public boolean deleteTransaction(int idT) {
        // TODO implement here
        return false;
    }

    /**
     * @param idT  
     * @return
     */
    public boolean validate(int idT ) {
        // TODO implement here
        return false;
    }

    /**
     * @param receipt 
     * @param idT 
     * @return
     */
    public boolean addReceipt(String receipt, int idT) {
        // TODO implement here
        return false;
    }

    /**
     * @param idT 
     * @return
     */
    public boolean deleteReceipt(int idT) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public ArrayList<Transaction> getAllTransaction() throws SQLException {
        ResultSet allTransaction = this.transactionDAO.selectAll();
        ArrayList<Transaction> transactions = new ArrayList<>();

        while(allTransaction.next())
        {
            int id = allTransaction.getInt("transaction_id");
            String label = allTransaction.getString("transaction_label");
            int amount = allTransaction.getInt("transaction_amount");
            String state = allTransaction.getString("transaction_state");
            String type = allTransaction.getString("transaction_type");
            Date date = allTransaction.getDate("transaction_date");
            String receipt = "";

            Transaction TR = new Transaction(id,label,amount,state,type,date,receipt);

            transactions.add(TR);
        }
        System.out.println(transactions);


        // TODO implement here
        return transactions;
    }

    /**
     * @return
     */
    public int getBalance() {
        // TODO implement here
        return 0;
    }

}