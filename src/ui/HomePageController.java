package ui;

import facade.FacadeManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    @FXML private Label userName;
    private FacadeManager facadeManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        facadeManager = null;
    }


    public void setFacadeManager(FacadeManager facadeManager){
        this.facadeManager = facadeManager;
        this.userName.setText(facadeManager.getLightUser().getFirstName());
    }



}
