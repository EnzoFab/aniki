package ui.treasury;

import business_logic.Transaction;
import facade.ExpenseFacade;
import facade.FacadeManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ui.Main;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ui.ViewBridge;

public class TransactionManagementController implements Initializable, ViewBridge {


    private ExpenseFacade expenseFacade;
    @FXML private ListView<String> listView;
    @FXML private ListView<String> listDebitView;
    @FXML private ListView<String> listCreditView;
    @FXML private Label valueCredit;
    @FXML private Label valueDebit;
    @FXML private Label valueTotal;
    public int totalDebit;
    public int totalCredit;
    public int total;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    @FXML private void LinkAddTransaction(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"addTransaction.fxml","AddTransaction");

    }


    @Override
    public void setData(FacadeManager fm, Object... p) {
        expenseFacade = fm.createExpenseFacade();
        init();
    }


    private void init(){
        this.total=0;
        this.totalCredit=0;
        this.totalDebit=0;

        ArrayList<Transaction> transactions = null;
        transactions = expenseFacade.getTransactionsList();
        ObservableList<String> data = FXCollections.observableArrayList();
        ObservableList<String> dataDebit = FXCollections.observableArrayList();
        ObservableList<String> dataCredit = FXCollections.observableArrayList();

        for (Transaction tr : transactions) {
            String dateString = null;
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(tr.getDate());
            try{
                dateString = sdfr.format( tr.getDate() );
            }catch (Exception ex ){
                System.out.println(ex);
            }

            data.add(dateString+" - "+tr.getLabel());
            if (tr.getType().equals("debit"))
            {
                dataCredit.add("");
                dataDebit.add(""+tr.getAmount());
                this.totalDebit+=tr.getAmount();
            }else{
                dataDebit.add("");
                dataCredit.add(""+tr.getAmount());
                this.totalCredit+=tr.getAmount();
            }
        }

        this.total = this.totalCredit-this.totalDebit;

        valueCredit.setText(""+this.totalCredit);
        valueDebit.setText(""+this.totalDebit);
        valueTotal.setText(""+this.total);
        listView.setItems(data);
        listCreditView.setItems(dataCredit);
        listDebitView.setItems(dataDebit);




    }
}
