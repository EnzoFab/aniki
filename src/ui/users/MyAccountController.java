package ui.users;

import business_logic.LightUser;
import facade.FacadeManager;
import facade.UserFacade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import ui.ViewBridge;

import java.net.URL;
import java.util.ResourceBundle;

import static ui.Main.showAlert;

public class MyAccountController implements Initializable, ViewBridge {

    private FacadeManager facadeManager;
    private LightUser user;

    @FXML private PasswordField oldPwdTextField;
    @FXML private PasswordField newPwdTextField1;
    @FXML private PasswordField newPwdTextField2;

    @FXML private TextField firstNameTF;
    @FXML private TextField nameTF;
    @FXML private TextField phoneTF;

    @FXML private Label mailLabel;
    @FXML private Label roleLabel;

    @FXML private Pane changePwdPane;



    private UserFacade userFacade;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void updatePwdButtonClick() {
        if(!newPwdTextField1.getText().equals(newPwdTextField2.getText()) &&
                !oldPwdTextField.getText().isEmpty() &&
                ( !newPwdTextField1.getText().isEmpty() || !newPwdTextField2.getText().isEmpty()) ){

            showAlert("Error","The passwords are different", Alert.AlertType.ERROR);

        }else if(oldPwdTextField.getText().isEmpty() && newPwdTextField1.getText().equals(newPwdTextField2.getText())  &&
                !newPwdTextField1.getText().isEmpty()){
            showAlert("Warning","A field is empty", Alert.AlertType.WARNING);
        }else if(! oldPwdTextField.getText().isEmpty() && newPwdTextField1.getText().equals(newPwdTextField2.getText())
                && !newPwdTextField1.getText().isEmpty()){
            if(userFacade.checkPwd(oldPwdTextField.getText())){
               if(userFacade.updatePwd(user.getMail(), newPwdTextField1.getText())){
                   showAlert("Update","Password successfully updated", Alert.AlertType.INFORMATION);
               }
            }else{
                showAlert("Error","Wrong password", Alert.AlertType.ERROR);
            }
        }
        clearPwdField();

    }

    @FXML private void updatePersonnalInfoButtonClick(MouseEvent mouseEvent) {
        String mail = user.getMail();
        String firstName = user.getFirstName();
        String name = user.getName();
        String phone = user.getPhone();

        if(!firstNameTF.getText().isEmpty())
            firstName = firstNameTF.getText();
        if(! nameTF.getText().isEmpty())
            name =  nameTF.getText();
        if( ! phoneTF.getText().isEmpty())
            phone = phoneTF.getText();

        if( userFacade.update(mail, firstName, name, phone) ){
            succesUpdate();
        }else{
            showAlert("Error", "Aniki couldn't update your personnal information", Alert.AlertType.ERROR);
        }

    }




    /**
     * initializate all components of the frame
     */
    private void init(){
        this.firstNameTF.setText(user.getFirstName());
        this.nameTF.setText(user.getName());
        this.phoneTF.setText(user.getPhone());

        this.mailLabel.setText(user.getMail());
        this.roleLabel.setText(user.getFirstName());
    }



    /**
     *
     */
    private void succesUpdate(){
        showAlert("Update","Your information were updated successfully", Alert.AlertType.INFORMATION);
        init();
    }

    private void clearPwdField(){
        oldPwdTextField.setText("");
        newPwdTextField1.setText("");
        newPwdTextField2.setText("");

    }


    @Override
    public void setData(FacadeManager fm, Object... p) {
        this.facadeManager = fm;
        this.user =facadeManager.getLightUser();
        this.userFacade = this.facadeManager.createUserFacade();

        this.init();
    }
}
