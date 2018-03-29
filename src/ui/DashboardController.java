package ui;

import facade.FacadeManager;
import facade.LoginFacade;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import persistent.ConnectionDB;
import ui.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import ui.users.CreateUserController;
import ui.users.MyAccountController;

import java.net.URL;
import java.util.ResourceBundle;

import static ui.Main.changeScene;

public class DashboardController implements Initializable {

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
        Main.changeScene(getClass(),"teams/teamsManagement.fxml","teams");

    }
    @FXML private void LinkAddTeamVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"teams/addTeam.fxml","AddTeam");

    }
    @FXML private void LinkContactVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"contact/contactManagement.fxml","Contacts");

    }
    @FXML private void LinkAddContactVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"contact/addContact.fxml","AddContact");

    }

    @FXML private void LinkEventsVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"events/eventsManagement.fxml","Events");

    }
    @FXML private void LinkAddEventVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"events/addEvent.fxml","AddEventController");

    }

    @FXML private void LinkTransactionVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"treasury/transactionManagement.fxml","Transactions");

    }
    @FXML private void LinkBudgetVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"treasury/budgetManagement.fxml","Budget");

    }

    @FXML private void LinkAnnualBudgetVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"treasury/annualBudgetManagement.fxml","AnnualBudget");

    }

    @FXML private void LinkInventoryVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"inventory/inventoryManagement.fxml","inventory");

    }
    @FXML private void LinkAddArticleVueGlobal(ActionEvent actionEvent) throws IOException {
        Main.changeScene(getClass(),"inventory/addArticle.fxml","AddArticle");

    }


    @FXML private void linkToUserManagement(ActionEvent actionEvent) {
        //System.out.println("manager null ? " +(facadeManager == null));
        moveMyAccountManagement();
        /*try {
            loadMyAccount();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML private void linkToCreateUser(ActionEvent actionEvent) {
        //System.out.println("manager null ? " +(facadeManager == null));
        moveToCreateUser();
        /*try {
            loadCreateUser();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * get Data from previous stage
     * @param fm
     */
    public void setData(FacadeManager fm){
        if(facadeManager == null)
            facadeManager = fm;
    }


    /**
     * Move to MyAccount Managemement
     */
    private void moveMyAccountManagement(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/users/myAccount.fxml"));
        Parent root ;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        MyAccountController myAccountController = loader.getController();
        myAccountController.setData(facadeManager);
        changeScene(root,"My Account");
    }

    /**
     * Move to MyAccount Managemement
     */
    private void moveToCreateUser(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui/users/createUser.fxml"));
        Parent root ;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        CreateUserController createUserController = loader.getController();
        //System.out.println("manager null ? " +(facadeManager == null));
        createUserController.setData(facadeManager);
        changeScene(root,"Create member");
    }

}
