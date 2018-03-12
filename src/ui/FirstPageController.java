package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FirstPageController {
    @FXML private Label labelLoading;

    public void buttonClick(MouseEvent mouseEvent) {
        labelLoading.setText("James a cliqué");
    }
}
