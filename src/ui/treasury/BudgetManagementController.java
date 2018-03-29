package ui.treasury;

import facade.BudgetFacade;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BudgetManagementController  implements Initializable{
    public ComboBox comboBoxSelectEventAdd;
    public TextField textFieldAmount;
    public BudgetFacade budgetFacade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        budgetFacade = new BudgetFacade();
        ArrayList<String> listEventname = null;
        try {
            listEventname = budgetFacade.getEventLeft();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        comboBoxSelectEventAdd.getItems().clear();
        comboBoxSelectEventAdd.getItems().addAll(listEventname);
    }

    public void onActionAdd(ActionEvent actionEvent) {

    }

    public void onActionSelectedTeamAdd(ActionEvent actionEvent) {
    }

    public void onActionSelectedEventAdd(ActionEvent actionEvent) {
        if(!textFieldAmount.getText().isEmpty() && !comboBoxSelectEventAdd.getValue().toString().isEmpty())
            budgetFacade.allocateNewBudget(Integer.parseInt(textFieldAmount.getText()), (String) comboBoxSelectEventAdd.getValue());
    }
}
