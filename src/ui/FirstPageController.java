package ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import persistent.ConnectionDB;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import static ui.Main.changeScene;

public class FirstPageController implements Initializable {
    boolean pass = false;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        while (ConnectionDB.getInstance() == null){

        }
        System.out.println("ici");
        try {
            Main.changeScene(getClass(),"/ui/users/login.fxml","Login");
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
