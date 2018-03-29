package facade;

import business_logic.Budget;
import business_logic.Transaction;
import persistent.daos.TransactionDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 */
public class ExpenseFacade {


    private TransactionDAO transactionDao;
    private ArrayList<Transaction> transactionsList;

    private final DaoFactory factory;
    private FacadeManager facadeManager;
    /**
     * Default constructor
     */
    public ExpenseFacade() {
        factory = DaoPostgresFactory.getInstance();
        this.transactionDao = factory.createTransactionDAO();
        this.transactionsList = new ArrayList<>();
        try {
            this.getAllTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
    public boolean addTransaction(String label , int amount, Date date, int state, String type) throws SQLException {
        Transaction transaction = new Transaction(label, amount, date, state, type);
        boolean stateResult = this.transactionDao.insert(transaction);

        if (stateResult) {
            // If the insert is ok, we get the id given by the database and add it to the java object before inserted it in the arrayList
            int idT = (int) this.transactionDao.selectLast().getObject("transaction_id");
            transaction.setIdT(idT);
            this.transactionsList.add(transaction);
        }
        return stateResult;
    }

    /**
     * @param idT 
     * @return
     */
    public boolean deleteTransaction(int idT) {
        // idT is the index of the event in the arrayList
        boolean state = this.transactionDao.delete(this.transactionsList.get(idT).getIdT());
        if (state){
            this.transactionsList.remove(idT);
        }
        return state;
    }

    /**
     * @param idT  
     * @return
     */
    public boolean validate(int idT) {
        //idT is the index of the event in the arrayList
        boolean state = this.transactionDao.update(this.transactionsList.get(idT).getIdT());
        if (state){
            this.transactionsList.get(idT).setState(1);
        }
        return state;
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
    public void getAllTransaction() throws SQLException {
        ResultSet result = this.transactionDao.selectAll();
        Transaction transaction;
        if (result.first()) {
            transaction = new Transaction(result.getString("transaction_label"), result.getInt("transaction_amount"), result.getDate("transaction_date"), result.getInt("transaction_state"), result.getString("transaction_type"));
            transaction.setIdT(result.getInt("transaction_id"));
            this.transactionsList.add(transaction);
            while(result.next()){
                transaction = new Transaction(result.getString("transaction_label"), result.getInt("transaction_amount"), result.getDate("transaction_date"), result.getInt("transaction_state"), result.getString("transaction_type"));
                transaction.setIdT(result.getInt("transaction_id"));
                this.transactionsList.add(transaction);
            }
        }
    }

    public ArrayList<Transaction> getTransactionsList() {
        return transactionsList;
    }

    /**
     * @return
     */
    public int getBalance() {
        // TODO implement here
        return 0;
    }

}