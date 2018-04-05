package ui.treasury;

import facade.BudgetFacade;
import facade.FacadeManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import ui.ViewBridge;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BudgetManagementController  implements Initializable, ViewBridge{
    public ComboBox comboBoxSelectEventAdd;
    public TextField textFieldAmount;
    public BudgetFacade budgetFacade;
    public ComboBox comboBoxSelectTeam;
    public ComboBox comboBoxSelectEvent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onActionAdd(ActionEvent actionEvent) {
        showDialogAddBuget();

    }


    public void onSelectedTeam(ActionEvent actionEvent) {
    }

    public void onSelectedEvent(ActionEvent actionEvent) {
    }

    private void showDialogAddBuget(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add new budget");
        dialog.setHeaderText("Care to enter an integer in the quantity field");


        ButtonType buttonInsertArticle = new ButtonType("Insert", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonInsertArticle, ButtonType.CANCEL);

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


        quantityTF.textProperty().addListener( ((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));


        dialog.getDialogPane().setContent(new VBox(8,quantityTF, event, team));

        //selection the first field
        Platform.runLater(() -> quantityTF.requestFocus());


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonInsertArticle) {
                int amount = Integer.parseInt(quantityTF.getText());
                String t = team.getValue();
                String s = event.getValue();
                try {
                    boolean a = budgetFacade.create(amount, s, t);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        });

        dialog.showAndWait();


    }

    @Override
    public void setData(FacadeManager fm, Object... p) {
        budgetFacade = fm.createBudgetFacade();
    }
}
