package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private Hyperlink forgotPwd;
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField mailField;

    public void mouseEntered(MouseEvent mouseEvent) {

    }
}
