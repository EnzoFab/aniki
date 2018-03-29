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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import persistent.ConnectionDB;
import ui.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionManagementController implements Initializable {


    private ExpenseFacade transactionFacade;
    @FXML private ListView<String> listView;
    @FXML private ListView<String> listDebitView;
    @FXML private ListView<String> listCreditView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        transactionFacade = new ExpenseFacade();
        ArrayList<Transaction> transactions = null;
        try {
            transactions = transactionFacade.getAllTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObservableList<String> data = FXCollections.observableArrayList();

        for (Transaction tr : transactions) {
            data.add("("+tr.getType()+") "+tr.getAmount()+" - "+ tr.getLabel());
        }

        listView.setItems(data);




    }


}
