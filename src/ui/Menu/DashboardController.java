package ui.Menu;

import facade.LoginFacade;
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
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

     @FXML private MenuItem TransactionVueGlobalButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }

    @FXML private void LinkTeamsVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Teams/teamsManagement.fxml","Teams");

    }
    @FXML private void LinkAddTeamVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Teams/addTeam.fxml","AddTeam");

    }
    @FXML private void LinkContactVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Contact/contactManagement.fxml","Contacts");

    }
    @FXML private void LinkAddContactVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Contact/addContact.fxml","AddContact");

    }

    @FXML private void LinkEventsVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Event/eventsManagement.fxml","Events");

    }
    @FXML private void LinkAddEventVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Event/addEvent.fxml","AddEventController");

    }

    @FXML private void LinkTransactionVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Tresorerie/transactionManagement.fxml","Transactions");

    }
    @FXML private void LinkBudgetVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Tresorerie/budgetManagement.fxml","Budget");

    }

    @FXML private void LinkAnnualBudgetVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Tresorerie/annualBudgetManagement.fxml","AnnualBudget");

    }

    @FXML private void LinkInventoryVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Inventory/inventoryManagement.fxml","Inventory");

    }
    @FXML private void LinkAddArticleVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../Inventory/addArticle.fxml","AddArticle");

    }

    @FXML private void LinkAccueilVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"../General/accueil.fxml","Accueil");

    }
}
