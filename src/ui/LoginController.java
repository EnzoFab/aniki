package ui;

import facade.LoginManager;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import persistent.ConnectionDB;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ui.Main.fadeEffect;
import static ui.Main.playSound;

public class LoginController implements Initializable {

    private final String BUTTON_DEFAULT_BG_COLOR = "#6666ff";
    private final String BUTTON_DEFAULT_TXT_COLOR = "#ffcc00";
    private final String HYPERLINK_DEFAULT_COLOR ="#000099";

    private final Image crossImg = new Image("media/img/red_cross.png");
    private final Image checkImg = new Image("media/img/check.png");


    private LoginManager loginManager;





    @FXML private Pane errorPane;

    @FXML private Button loginButton;

    @FXML private Hyperlink forgotPwd;

    @FXML private PasswordField passwordField;

    @FXML private TextField mailField;

    @FXML private Label errorInformation;

    /**
     * red cross if
     */
    @FXML private ImageView stateImg;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorPane.setVisible(false); // hide the errorPane
        ConnectionDB.getInstance(); // deplace in the first page
        loginManager = new LoginManager();
        stateImg.setImage(crossImg);
        stateImg.setVisible(false);

        mailField.textProperty().addListener((obs, oldText, newText) -> {
           if(!stateImg.isVisible()){
                stateImg.setVisible(true);
            }
            if(loginManager.exists(newText) )
                stateImg.setImage(checkImg);

        });



    }

    /*
    ********************************************************************************************************************
                                                    FXML Methods
    ********************************************************************************************************************
     */

    @FXML private void hyperlinkClick(MouseEvent mouseEvent) throws IOException {
        Main.changeScene(getClass(),"forgotPassword.fxml","Forgot password");

    }

    @FXML private void hyperlinkMouseEntered(MouseEvent mouseEvent) {
        forgotPwd.setStyle("-fx-text-fill: #d6d6f5; -fx-text-fill:"+BUTTON_DEFAULT_TXT_COLOR);
    }

    @FXML private void hyperlinkMouseExited(MouseEvent mouseEvent) {
        forgotPwd.setStyle("-fx-text-fill: "+HYPERLINK_DEFAULT_COLOR);
    }

    @FXML private void buttonLoginClick() {
        //checkImg if fields aren't empty
        if(passwordField.getText().isEmpty() && mailField.getText().isEmpty() ){
            passwordField.setStyle("-fx-background-color: #ff471a");
            mailField.setStyle("-fx-background-color: #ff471a");

            showError("All fields are not filled");


        }else if(passwordField.getText().isEmpty()){
            passwordField.setStyle("-fx-background-color: #ff471a");
            showError("All fields are not filled");
            clearField();

        }else if(mailField.getText().isEmpty()){
            mailField.setStyle("-fx-background-color: #ff471a");
            showError("All fields are not filled");
            clearField();
        }else{
            String resultat = loginManager.login(mailField.getText(),passwordField.getText());
            clearField();
            switch (resultat){
                case "Success":
                    // connection with success
                    System.out.println("Connection success");
                    break;
                case "Error":
                    this.showError("An error has occured please contact the administrator");
                    break;
                case "Failed":
                    this.showError("Wrong password and/or email please check it out and retry");
                    break;
            }

        }
    }

    @FXML private void mailClick() {
        mailField.setStyle("-fx-background-color: white");
        if(errorPane.isVisible())
            hideError();

    }

    @FXML private void pwdClick() {
        passwordField.setStyle("-fx-background-color: white");
        if(errorPane.isVisible())
            hideError();
    }

    @FXML private void buttonLoginMouseEntered(MouseEvent mouseEvent) {
        loginButton.setStyle("-fx-background-color: #ccccff; -fx-text-fill: #0f0f3d");
            // change the button background


    }

    @FXML private void buttonLoginMouseExited(MouseEvent mouseEvent) {
        this.loginButton.setStyle("-fx-background-color: "+ BUTTON_DEFAULT_BG_COLOR);
    }



    /**
     * When a text is typed in the password field
     * @param keyEvent
     */
    @FXML private void pwdKeyEntered(KeyEvent keyEvent) {
        pwdClick();
        if(keyEvent.getCode() == KeyCode.ENTER)
            buttonLoginClick();
    }

    /**
     * When a text is typed in the mail field
     * @param keyEvent
     */
    public void mailKeyEntered(KeyEvent keyEvent) {
        mailClick();
        if(keyEvent.getCode() == KeyCode.ENTER)
            buttonLoginClick();
        else if(keyEvent.getCode() == KeyCode.BACK_SPACE){
            if(mailField.getText().isEmpty())
                stateImg.setVisible(false);
            else if(loginManager.exists(mailField.getText()) && ! stateImg.getImage().equals(checkImg))
                stateImg.setImage(checkImg);
            else if(stateImg.getImage().equals(checkImg))
                stateImg.setImage(crossImg);

        }

    }



    /*
    ********************************************************************************************************************
                                                    Basic Methods
    ********************************************************************************************************************
     */





    /**
     * Display the error pane with the customized error text
     * @param error
     */
    private void showError(String error){
        errorInformation.setText(error);
        errorPane.setVisible(true);
        fadeEffect(0,1,150,errorPane);
        playSound("src/media/sound/error.mp3");
    }

    /**
     * Hide the errorPane
     */
    private void hideError(){
        errorPane.setVisible(false);
        fadeEffect(1,0,200,errorPane);
    }


    /**
     * Delete the text in the Field
     */
    private void clearField(){
        passwordField.setText("");
        mailField.setText("");
        stateImg.setImage( crossImg);
        stateImg.setVisible(false);


    }
}
