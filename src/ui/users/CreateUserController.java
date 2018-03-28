package ui.users;

import facade.FacadeManager;
import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import ui.Main;

import java.net.URL;
import java.util.ResourceBundle;

import static ui.Main.fadeEffect;
import static ui.Main.showAlert;

public class CreateUserController implements Initializable{



    private FacadeManager facadeManager;
    private UserFacade userFacade;

    @FXML private TextField mailTF;
    @FXML private TextField firstNameTF;
    @FXML private TextField nameTF;
    @FXML private TextField phoneTF;

    @FXML private PasswordField pwdTF1;
    @FXML private PasswordField pwdTF2;





    @FXML private Label errorLabel;
    @FXML private Pane errorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorPane.setVisible(false);

    }

    @FXML private void createUserClick(MouseEvent mouseEvent) {
        if(!emptyField()){
            if(pwdTF1.getText().equals(pwdTF2.getText())){
                if(userFacade.create(mailTF.getText(), firstNameTF.getText(), nameTF.getText(),
                        pwdTF1.getText(), phoneTF.getText()))
                    showAlert("User Create", firstNameTF.getText()+ " had successfully created",
                            Alert.AlertType.INFORMATION);
                else
                    displayError("An error has occured");
            }else{
                displayError("Passwords are differents");
            }
        }else{
            displayError("A field is empty");

        }
    }

   /* @FXML private void keyPressPane(KeyEvent keyEvent) {
        hideError();
    }

    @FXML private void clickOnPane(MouseEvent mouseEvent) {
        hideError();
    }*/


    public void setData(FacadeManager facadeManager){
        this.facadeManager = facadeManager;
        this.facadeManager.createUserFacade();
        userFacade = this.facadeManager.getUserFacade();
    }

    /**
     * return true if at least one field is empty
     * @return
     */
    private boolean emptyField(){
        return mailTF.getText().isEmpty() || firstNameTF.getText().isEmpty() || nameTF.getText().isEmpty() ||
                phoneTF.getText().isEmpty() || pwdTF1.getText().isEmpty() || pwdTF2.getText().isEmpty();
    }

    private void displayError(String txt){
        fadeEffect(0,1,300,errorPane);
        errorPane.setVisible(true);
        errorLabel.setText(txt);
    }


    private void hideError(){
        fadeEffect(1,0,300,errorPane);
        errorPane.setVisible(false);
    }


}
