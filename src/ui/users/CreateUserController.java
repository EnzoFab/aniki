package ui.users;

import facade.FacadeManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateUserController implements Initializable{

    private FacadeManager facadeManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void createUserClick(MouseEvent mouseEvent) {
    }


    public void setData(FacadeManager facadeManager){
        this.facadeManager = facadeManager;
    }
}
