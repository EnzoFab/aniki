package ui.events;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.text.ParseException;

import facade.*;
import ui.Main;

public class AddEventController {

    public TextField nomEvent;
    public TextField dateDebutEvent;
    public TextField dateFinEvent;
    public TextField nombreEvent;
    public TextField teamInput;

    private EventFacade eventFacade;


    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void addEvent(ActionEvent actionEvent) throws SQLException, ParseException, IOException {
        this.eventFacade = new EventFacade(teamInput.getText());
        if(!nomEvent.getText().isEmpty() && !dateDebutEvent.getText().isEmpty() && !dateFinEvent.getText().isEmpty() && !nombreEvent.getText().isEmpty()){

            DateFormat formatterPG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSX");

            String dd = dateDebutEvent.getText();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut=formatter.parse(dd);

            String de = dateFinEvent.getText();
            DateFormat formatterE = new SimpleDateFormat("yyyy-MM-dd");
            Date dateFin=formatter.parse(de);

            dateDebut=new Timestamp(dateDebut.getTime());
            dateFin=new Timestamp(dateFin.getTime());

            System.out.println(dateDebut);
            System.out.println(dateFin);
            System.out.println(nomEvent.getText());
            System.out.println(Integer.parseInt(nombreEvent.getText()));

            eventFacade.addEvent(nomEvent.getText(),dateDebut ,dateFin, Integer.parseInt(nombreEvent.getText()));

            Main.changeScene(getClass(),"eventsManagement.fxml","Events Management");
        }
    }

}
