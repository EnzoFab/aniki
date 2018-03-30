package ui.treasury;

import facade.AnualBudgetFacade;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;


public class AnnualBudgetManagementController implements Initializable {

    public ComboBox comboBoxAnualBudget;
    public Label labelAmount;
    public Label labelListName;
    public Label labelAmountLeft;
    private ArrayList<Integer> listNameSet = null;


    private AnualBudgetFacade anualBudgetFacade;

    public void onSelectedYear(ActionEvent actionEvent){
        int year = (int) this.comboBoxAnualBudget.getValue();
        int amount = anualBudgetFacade.getAnulaBudgetFromYear(year);
        if(amount != -1){
            String listName = anualBudgetFacade.getListName();
            labelAmount.setText(String.valueOf(amount));
            labelListName.setText(listName);
        }
        else{
            System.out.println("erreur");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anualBudgetFacade = new AnualBudgetFacade();
        try {
            listNameSet = anualBudgetFacade.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        comboBoxAnualBudget.getItems().clear();
        comboBoxAnualBudget.getItems().addAll(listNameSet);
    }


    public void addActionAnualBudget(ActionEvent actionEvent) {

        showDialogAddAnualBudget();
    }


    public void deleteAction(ActionEvent actionEvent) {
        int value = (int) comboBoxAnualBudget.getValue();
        if(anualBudgetFacade.delete(value)){
            comboBoxAnualBudget.getItems().clear();
            listNameSet.remove(new Integer(value));
            comboBoxAnualBudget.getItems().addAll(listNameSet);
            labelListName.setText("");
            labelAmount.setText("");
        }

    }

    public void updateAction(ActionEvent actionEvent) {
        showDialogUpdateAnualBudget();
    }

    private void showDialogUpdateAnualBudget(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Update anual budget");
        dialog.setHeaderText("Care to enter an integer in the quantity field");


        ButtonType buttonInsertArticle = new ButtonType("Insert", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonInsertArticle, ButtonType.CANCEL);



        TextField listNameTF = new TextField();
        listNameTF.setPromptText("List Name");

        TextField amountTF = new TextField();
        amountTF.setPromptText("Amount");


        Node submitButton = dialog.getDialogPane().lookupButton(buttonInsertArticle);
        submitButton.setDisable(true);


        listNameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });

        amountTF.textProperty().addListener(((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));


        dialog.getDialogPane().setContent(new VBox(8, listNameTF, amountTF));


        Platform.runLater(() -> listNameTF.requestFocus());


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonInsertArticle) {
                String listName = listNameTF.getText();
                int amount = Integer.parseInt(amountTF.getText());
                if(anualBudgetFacade.update(listName, amount));
            }
            return null;
        });

        dialog.showAndWait();
    }


    private void showDialogAddAnualBudget(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Update anual budget");
        dialog.setHeaderText("Care to enter an integer in the quantity field");


        ButtonType buttonInsertArticle = new ButtonType("Insert", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonInsertArticle, ButtonType.CANCEL);



        TextField listNameTF = new TextField();
        listNameTF.setPromptText("List Name");

        TextField amountTF = new TextField();
        amountTF.setPromptText("Amount");


        Node submitButton = dialog.getDialogPane().lookupButton(buttonInsertArticle);
        submitButton.setDisable(true);


        listNameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });

        amountTF.textProperty().addListener(((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));


        dialog.getDialogPane().setContent(new VBox(8, listNameTF, amountTF));


        Platform.runLater(() -> listNameTF.requestFocus());


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonInsertArticle) {
                String listName = listNameTF.getText();
                int amount = Integer.parseInt(amountTF.getText());
                Calendar calendrier;
                calendrier = Calendar.getInstance();
                int anneeEnCours = calendrier.get(Calendar.YEAR);
                if(anualBudgetFacade.create(listName, anneeEnCours, amount))
                    comboBoxAnualBudget.getItems().add(anneeEnCours);
            }
            return null;
        });

        dialog.showAndWait();

    }
}
