package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ui.Main.fadeEffect;
import static ui.Main.playSound;

public class ForgotPasswordController implements Initializable{

    private final String BUTTON_DEFAULT_BG_COLOR = "#6666ff";
    private final String BUTTON_DEFAULT_TXT_COLOR = "#ffcc00";
    private final String HYPERLINK_DEFAULT_COLOR ="#000099";

    private final Image crossImg = new Image("media/img/red_cross.png");
    private final Image checkImg = new Image("media/img/check.png");



    @FXML private Label errorText;

    @FXML private Pane errorPane;

    @FXML private Button resetButton;

    @FXML private  TextField mailField;

    @FXML private ImageView stateImg;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorPane.setVisible(false);
        stateImg.setVisible(false);

    }

    @FXML private void mailKeyEntered(KeyEvent keyEvent) {
    }

    @FXML private void mailClick(MouseEvent mouseEvent) {
    }

    @FXML private void buttonLoginClick(MouseEvent mouseEvent) {
        if(mailField.getText().isEmpty()){
            showError("Please fill the field below");
        }else{
            // check if the mail exist
            // use facade method in order to reset the pwd and send it by mail
        }
    }

    @FXML private void buttonLoginMouseEntered(MouseEvent mouseEvent) {
        resetButton.setStyle("-fx-background-color: #ccccff; -fx-text-fill: #0f0f3d");
    }

    @FXML private void buttonLoginMouseExited(MouseEvent mouseEvent) {
        resetButton.setStyle("-fx-background-color: "+ BUTTON_DEFAULT_BG_COLOR);
    }

    /**
     * Back arrow to return to the login page
     * @param mouseEvent
     * @throws IOException
     */
    @FXML private void back(MouseEvent mouseEvent) throws IOException {
        Main.changeScene(getClass(),"login.fxml","Login");
    }


    private void showError(String error){
        errorText.setText(error);
        errorPane.setVisible(true);
        fadeEffect(0,1,150,errorPane);
        playSound("src/media/sound/error.mp3");
    }


}
