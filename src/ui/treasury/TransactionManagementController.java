package ui.treasury;

import business_logic.Transaction;
import facade.AnualBudgetFacade;
import facade.ExpenseFacade;
import facade.LoginFacade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.net.URL;
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
        ObservableList<String> dataDebit = FXCollections.observableArrayList();
        ObservableList<String> dataCredit = FXCollections.observableArrayList();

        for (Transaction tr : transactions) {
            String dateString = null;
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(tr.getTransaction());
            try{
                dateString = sdfr.format( tr.getTransaction() );
            }catch (Exception ex ){
                System.out.println(ex);
            }

            data.add(dateString+" - "+tr.getLabel());
            if (tr.getType().equals("debit"))
            {
                dataCredit.add("");
                dataDebit.add(""+tr.getAmount());
            }else{
                dataDebit.add("");
                dataCredit.add(""+tr.getAmount());
            }
        }

        listView.setItems(data);
        listCreditView.setItems(dataCredit);
        listDebitView.setItems(dataDebit);




    }


}
