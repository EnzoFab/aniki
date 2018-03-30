package ui;

import facade.FacadeManager;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import static ui.Main.changeScene;

public class DashboardController implements Initializable, ViewBridge{

    @FXML private AnchorPane anchorPane;
    @FXML private MenuItem TransactionVueGlobalButton;

    /**
     * it recreate the object when we change screen
     * so we set a static variable
     */
    private static FacadeManager facadeManager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void LinkTeamsVueGlobal(ActionEvent actionEvent) throws IOException {
        //Main.changeScene(getClass(),"teams/teamsManagement.fxml","teams");
        performBridge("/ui/teams/teamsManagement.fxml","teams");

    }

    @FXML private void LinkContactVueGlobal(ActionEvent actionEvent) throws IOException {
        //Main.changeScene(getClass(),"contact/contactManagement.fxml","Contacts");
        performBridge("/ui/contact/contactManagement.fxml","Contacts");

    }
    @FXML private void LinkAddContactVueGlobal(ActionEvent actionEvent) throws IOException {
        //Main.changeScene(getClass(),"contact/addContact.fxml","AddContact");
        performBridge("/ui/contact/addContact.fxml","Add contact");

    }

    @FXML private void LinkEventsVueGlobal(ActionEvent actionEvent) throws IOException {
        performBridge("/ui/events/eventsManagement.fxml","Events");

    }

    @FXML private void LinkTransactionVueGlobal(ActionEvent actionEvent) throws IOException {
        //Main.changeScene(getClass(),"treasury/transactionManagement.fxml","Transactions");
        this.performBridge("/ui/treasury/transactionManagement.fxml","Transactions");

    }
    @FXML private void LinkBudgetVueGlobal(ActionEvent actionEvent) throws IOException {
        //Main.changeScene(getClass(),"treasury/budgetManagement.fxml","Budget");
        performBridge("/ui/treasury/budgetManagement.fxml","Budget");

    }

    @FXML private void LinkAnnualBudgetVueGlobal(ActionEvent actionEvent) throws IOException {
        //Main.changeScene(getClass(),"treasury/annualBudgetManagement.fxml","AnnualBudget");
        performBridge("/ui/treasury/annualBudgetManagement.fxml","AnnualBudget");

    }

    @FXML private void LinkInventoryVueGlobal(ActionEvent actionEvent) throws IOException {
        performBridge("/ui/inventory/inventoryManagement.fxml","Inventory");

    }



    @FXML private void linkToUserManagement(ActionEvent actionEvent) {
        //System.out.println("manager null ? " +(facadeManager == null));
        performBridge("/ui/users/myAccount.fxml","My Account");

    }

    @FXML private void linkToCreateUser(ActionEvent actionEvent) {
        performBridge("/ui/users/createUser.fxml","Create member");
    }

    @FXML private void logoff(ActionEvent actionEvent) throws IOException {
        facadeManager = null; // reset facade manager
        changeScene(getClass(),"users/login.fxml","login");
    }


    /**
     * Perform bridge meanse that the scene is changed and we passe data to a ViewBridge
     * @param destination
     * @param title
     */
    private void performBridge(String destination, String title){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(destination));
        Parent root ;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ViewBridge bridge = loader.getController();
        bridge.setData(facadeManager);
        changeScene(root,title);
    }




    @Override
    public void setData(FacadeManager fm, String... p) {
        if(facadeManager == null)
            facadeManager = fm;

    }


}
