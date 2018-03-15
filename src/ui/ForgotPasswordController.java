package ui;

import facade.LoginManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ui.Main.changeScene;
import static ui.Main.fadeEffect;
import static ui.Main.playSound;

public class ForgotPasswordController implements Initializable{

    private final String BUTTON_DEFAULT_BG_COLOR = "#6666ff";
    private final String BUTTON_DEFAULT_TXT_COLOR = "#ffcc00";
    private final String HYPERLINK_DEFAULT_COLOR ="#000099";

    private final Image crossImg = new Image("media/img/red_cross.png");
    private final Image checkImg = new Image("media/img/check.png");

    private final Image backArrowImg = new Image("media/img/back_arrow.png");
    private final Image blueBackArrowImg = new Image("media/img/back_arrow.png");




    private LoginManager loginManager;



    @FXML private Label errorText;

    @FXML private Pane errorPane;

    @FXML private Button resetButton;

    @FXML private  TextField mailField;

    @FXML private ImageView stateImg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorPane.setVisible(false);
        stateImg.setVisible(false);
        loginManager = new LoginManager();



        mailField.textProperty().addListener((obs, oldText, newText) -> {
            if(!stateImg.isVisible()){
                stateImg.setVisible(true);
            }
            if(loginManager.exists(newText) ){
                stateImg.setImage(checkImg);

            }


        });


    }

    @FXML private void mailKeyEntered(KeyEvent keyEvent) {
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

    @FXML private void mailClick() {
        mailField.setStyle("-fx-background-color: white");
        if(errorPane.isVisible())
            hideError();
    }



    @FXML private void buttonLoginClick() {
        if(mailField.getText().isEmpty()){
            mailField.setStyle("-fx-background-color: #ff471a");
            showError("Please fill the field below");
        }else{
            // check if the mail exist
            // use facade method in order to reset the pwd and send it by mail
        }
    }

    @FXML private void buttonLoginMouseEntered(MouseEvent mouseEvent) {
        resetButton.setStyle("-fx-background-color: #ccccff; -fx-text-fill: #0f0f3d;" +
                " -fx-background-radius: 10; "+
                " -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); ");
    }

    @FXML private void buttonLoginMouseExited(MouseEvent mouseEvent) {
        resetButton.setStyle("-fx-background-color: "+ BUTTON_DEFAULT_BG_COLOR+"; " +
                "-fx-background-radius: 10;" +
                " -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); ");
    }

    /**
     * Back arrow to return to the login page
     * @param mouseEvent
     * @throws IOException
     */
    @FXML private void back(MouseEvent mouseEvent) throws IOException {
        changeScene(getClass(),"login.fxml","Login");
    }


    private void showError(String error){
        errorText.setText(error);
        errorPane.setVisible(true);
        fadeEffect(0,1,150,errorPane);
        playSound("src/media/sound/error.mp3");
    }

    private void hideError() {
        errorPane.setVisible(false);
        fadeEffect(1,0,200,errorPane);
    }


    @FXML private void imageMouseOut(MouseEvent mouseEvent) {
    }

    @FXML private void imageMouseIn(MouseEvent mouseEvent) {
    }
}
