package ui.treasury;

import facade.AnualBudgetFacade;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;


public class AnnualBudgetManagementController implements Initializable {

    private AnualBudgetFacade anualBudgetFacade;

    public void onSelectedYear(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        anualBudgetFacade = new AnualBudgetFacade();
    }


    public void addActionAnualBudget(ActionEvent actionEvent) {
        anualBudgetFacade.create("hello", 23, 24);
    }
}
