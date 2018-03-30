package ui.treasury;

import facade.AnualBudgetFacade;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;


public class AnnualBudgetManagementController implements Initializable {

    public TextField textFieldAmount;
    public TextField textFieldListName;
    public ComboBox comboBoxAnualBudget;
    public Label labelAmount;
    public Label labelListName;
    public Label labelAmountLeft;

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
        ArrayList<Integer> listNameSet = null;
        try {
            listNameSet = anualBudgetFacade.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        comboBoxAnualBudget.getItems().clear();
        comboBoxAnualBudget.getItems().addAll(listNameSet);
    }


    public void addActionAnualBudget(ActionEvent actionEvent) {
        Calendar calendrier;
        calendrier = Calendar.getInstance();
        int anneeEnCours = calendrier.get(Calendar.YEAR);
        if(!textFieldListName.getText().isEmpty() && !textFieldAmount.getText().isEmpty()){
            anualBudgetFacade.create(textFieldListName.getText(), anneeEnCours, Integer.parseInt(textFieldAmount.getText()));
            comboBoxAnualBudget.getItems().add(anneeEnCours);
        }
        textFieldAmount.setText("");
        textFieldListName.setText("");
    }

}
