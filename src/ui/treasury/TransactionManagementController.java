package ui.treasury;

import business_logic.Transaction;
import facade.ExpenseFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TransactionManagementController implements Initializable {


    private ExpenseFacade expenseFacade;
    @FXML private ListView<String> listView;
    @FXML private ListView<String> listDebitView;
    @FXML private ListView<String> listCreditView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        expenseFacade = new ExpenseFacade();
        ArrayList<Transaction> transactions = null;
        transactions = expenseFacade.getTransactionsList();
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Transaction tr : transactions) {
            data.add("("+tr.getType()+") "+tr.getAmount()+" - "+ tr.getLabel());
        }

        listView.setItems(data);




    }


}
