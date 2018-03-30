package ui.treasury;

import facade.BudgetFacade;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BudgetManagementController  implements Initializable{
    public ComboBox comboBoxSelectEventAdd;
    public TextField textFieldAmount;
    public BudgetFacade budgetFacade;
    public ComboBox comboBoxSelectTeam;
    public ComboBox comboBoxSelectEvent;

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
        if(!textFieldAmount.getText().isEmpty() && !comboBoxSelectEventAdd.getValue().toString().isEmpty()){
            budgetFacade.allocateNewBudget(Integer.parseInt(textFieldAmount.getText()), (String) comboBoxSelectEventAdd.getValue());
        }
    }


    public void onSelectedTeam(ActionEvent actionEvent) {
    }

    public void onSelectedEvent(ActionEvent actionEvent) {
    }

    private void showDialogAddArticle(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add new budget");
        dialog.setHeaderText("Care to enter an integer in the quantity field");


        ButtonType buttonInsertArticle = new ButtonType("Insert", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonInsertArticle, ButtonType.CANCEL);


        TextField nameTF = new TextField();
        nameTF.setPromptText("Name");

        TextField quantityTF = new TextField();
        quantityTF.setPromptText("Quantity");

        ObservableList options =
                null;

        ObservableList teamOption = null;
        try {
            options = FXCollections.observableArrayList(budgetFacade.getEventLeft());
            teamOption = FXCollections.observableArrayList(budgetFacade.getTeam());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // load from the database


        ComboBox<String> event = new ComboBox<String>(options );
        event.getSelectionModel().selectFirst();

        ComboBox<String> team = new ComboBox<String>(teamOption );
        team.getSelectionModel().selectFirst();


        Node submitButton = dialog.getDialogPane().lookupButton(buttonInsertArticle);
        submitButton.setDisable(true);


        nameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });

        quantityTF.textProperty().addListener( ((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));


        dialog.getDialogPane().setContent(new VBox(8,nameTF,quantityTF, event, team));


        Platform.runLater(() -> nameTF.requestFocus());


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonInsertArticle) {

            }
            return null;
        });

        dialog.showAndWait();


    }
}
