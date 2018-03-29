package ui.events;

import business_logic.Event;
import facade.EventFacade;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EventsManagementController implements Initializable{
    private EventFacade eventFacade;
    @FXML
    private ListView<String> listEvents;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        eventFacade = new EventFacade("com");
        ArrayList<Event> events = null;
        events = eventFacade.getEventList();

        ObservableList<String> data = FXCollections.observableArrayList();

        for (Event E : events) {
            String dateDebut = null;
            String dateFin = null;
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
            try{
                dateDebut = sdfr.format( E.getDateStart() );
                dateFin = sdfr.format( E.getDateEnd() );
            }catch (Exception ex ){
                System.out.println(ex);
            }

            data.add(dateDebut+" - "+dateFin+" : "+E.getLabel());

        }

        listEvents.setItems(data);





    }


}
