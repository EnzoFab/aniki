package facade;

import business_logic.Budget;
import business_logic.Transaction;
import business_logic.User;
import persistent.daos.PaymentMethodDAO;
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
    private PaymentMethodDAO paymentmethodDao;
    private ArrayList<Transaction> transactionsList;
    private ArrayList<String> paymentMethodsList;
    private final User connectUser;


    /**
     * Default constructor
     */
    public ExpenseFacade(User user) {
        this.connectUser = user;
        DaoFactory factory = DaoPostgresFactory.getInstance();
        this.transactionDao = factory.createTransactionDAO();
        this.paymentmethodDao = factory.createPaymentMethodDAO();

        this.transactionsList = new ArrayList<>();
        this.paymentMethodsList = new ArrayList<>();
        try {
            this.getAllTransaction();
            this.getAllPaymentmethods();
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
     *
     * @param idT
     * @param paymentmethod_name
     * @return
     */
    public boolean addPaymentMethod(int idT, String paymentmethod_name) {
        //idT is the index of the event in the arrayList
        System.out.println("Hey");
        boolean state = this.transactionDao.insertPaymentMethod(this.transactionsList.get(idT).getIdT(), paymentmethod_name);
        if (state){
            this.transactionsList.get(idT).setPaymentmethod(paymentmethod_name);
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
     *
     * @throws SQLException
     */
    public void getAllPaymentmethods() throws SQLException {
        ResultSet result = this.paymentmethodDao.getAll();
        String payment;
        if (result.first()) {
            payment = result.getString("paymentmethod_name");
            this.paymentMethodsList.add(payment);
            while(result.next()){
                payment = result.getString("paymentmethod_name");
                this.paymentMethodsList.add(payment);
            }
        }
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
            transaction.setPaymentmethod(result.getString("paymentmethod_name"));

            this.transactionsList.add(transaction);
            while(result.next()){
                transaction = new Transaction(result.getString("transaction_label"), result.getInt("transaction_amount"), result.getDate("transaction_date"), result.getInt("transaction_state"), result.getString("transaction_type"));
                transaction.setIdT(result.getInt("transaction_id"));
                transaction.setPaymentmethod(result.getString("paymentmethod_name"));

                this.transactionsList.add(transaction);
            }
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Transaction> getTransactionsList() {
        return transactionsList;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getPaymentMethodsList() {
        return paymentMethodsList;
    }

    /**
     * @return
     */
    public int getBalance() {
        // TODO implement here
        return 0;
    }

}