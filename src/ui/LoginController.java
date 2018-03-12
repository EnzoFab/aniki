package ui;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import persistent.ConnectionDB;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private final String BUTTON_DEFAULT_BG_COLOR = "#6666ff";
    private final String BUTTON_DEFAULT_TXT_COLOR = "#ffcc00";
    private final String HYPERLINK_DEFAULT_COLOR ="#000099";





    @FXML private Pane errorPane;

    @FXML private Button loginButton;

    @FXML private Hyperlink forgotPwd;

    @FXML private PasswordField passwordField;

    @FXML private TextField mailField;

    @FXML private Label errorInformation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorPane.setVisible(false); // hide the errorPane
        ConnectionDB.getInstance(); // deplace in the first page

    }


  
    public void hyperlinkClick(MouseEvent mouseEvent) {

    }

    public void hyperlinkMouseEntered(MouseEvent mouseEvent) {
        forgotPwd.setStyle("-fx-text-fill: #d6d6f5; -fx-text-fill:"+BUTTON_DEFAULT_TXT_COLOR);
    }

    public void hyperlinkMouseExited(MouseEvent mouseEvent) {
        forgotPwd.setStyle("-fx-text-fill: "+HYPERLINK_DEFAULT_COLOR);
    }

    public void buttonLoginClick(MouseEvent mouseEvent) {
        //check if fields aren't empty
        if(passwordField.getText().isEmpty() && mailField.getText().isEmpty() ){
            passwordField.setStyle("-fx-background-color: #ff471a");
            mailField.setStyle("-fx-background-color: #ff471a");

            showError("All fields are not filled");


        }else if(passwordField.getText().isEmpty()){
            passwordField.setStyle("-fx-background-color: #ff471a");
            showError("All fields are not filled");

        }else if(mailField.getText().isEmpty()){
            mailField.setStyle("-fx-background-color: #ff471a");
            showError("All fields are not filled");
        }else{

        }
    }

    public void buttonLoginMouseEntered(MouseEvent mouseEvent) {
        loginButton.setStyle("-fx-background-color: #ccccff; -fx-text-fill: #0f0f3d");
            // change the button background


    }

    public void buttonLoginMouseExited(MouseEvent mouseEvent) {
        this.loginButton.setStyle("-fx-background-color: "+ BUTTON_DEFAULT_BG_COLOR);
    }

    /**
     * Fade in or out a Region
     * all component extends of Region
     * a and b determine the type of fade
     * if a =1 and b= 0 fade out else if
     * a= 0 and b= 1 fade in
     * @param a
     * @param b
     * @param duration
     * @param r
     */
    private void fadeEffect(int a, int b, int duration,Region r){
        FadeTransition ft = new FadeTransition(Duration.millis(duration), r);
        ft.setFromValue(a);
        ft.setToValue(b);
        ft.play();
    }

    private void playSound(String filename){
        Media sound = new Media(new File(filename).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }


    private void showError(String error){
        errorInformation.setText(error);
        errorPane.setVisible(true);
        fadeEffect(0,1,150,errorPane);
        playSound("src/media/sound/error.mp3");
    }

}
