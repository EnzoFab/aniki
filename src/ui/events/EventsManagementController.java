package ui.events;

import business_logic.Article;
import business_logic.Event;
import facade.EventFacade;
import facade.FacadeManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import ui.ViewBridge;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class EventsManagementController implements Initializable, ViewBridge{
    private EventFacade eventFacade;
    @FXML
    private ListView<String> listEvents;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    private void init(){
        ArrayList<Event> events = null;
        events = eventFacade.getEventList();

        ObservableList<String> data = FXCollections.observableArrayList();

        for (Event e : events) {
            String dateDebut = null;
            String dateFin = null;
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
            try{
                dateDebut = sdfr.format( e.getDateStart() );
                dateFin = sdfr.format( e.getDateEnd() );
            }catch (Exception ex ){
                System.out.println(ex);
            }

            data.add(dateDebut+" - "+dateFin+" : "+e.getLabel());

        }
        listEvents.setItems(data);
    }

    @Override
    public void setData(FacadeManager fm, String ...p) {
        if(p.length >=1)
            eventFacade = fm.createEventFacade(p[0]);
        else
            eventFacade = fm.createEventFacade();
        init();
    }


    private void showDialogAddEvent(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add new Event");
        dialog.setHeaderText("Care to enter an integer in the quantity field");


        ButtonType buttonInserEvent = new ButtonType("Insert", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonInserEvent, ButtonType.CANCEL);


        TextField eventNameTF = new TextField();
        eventNameTF.setPromptText("Event Name");

        final DatePicker datePickerBeginEvent = new DatePicker();
        final DatePicker datePickerEndEvent = new DatePicker();


        TextField quantityTF = new TextField();
        quantityTF.setPromptText("Quantity");

        ObservableList options =
                FXCollections.observableArrayList(eventFacade.getAllTeam());


        ComboBox<String> teamCB= new ComboBox<>(options);
        teamCB.getSelectionModel().selectFirst();

        Node submitButton = dialog.getDialogPane().lookupButton(buttonInserEvent);
        submitButton.setDisable(true);


        eventNameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });

        quantityTF.textProperty().addListener( ((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));


        dialog.getDialogPane().setContent(new VBox(8,eventNameTF,quantityTF, datePickerBeginEvent,datePickerEndEvent,teamCB));


        Platform.runLater(() -> eventNameTF.requestFocus());


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonInserEvent) {
                addEvent(eventNameTF.getText(),datePickerBeginEvent.getValue(), datePickerEndEvent.getValue(),
                        Integer.parseInt(quantityTF.getText()), teamCB.getValue());
            }
            return null;
        });

        dialog.showAndWait();


    }


    /**
     *
     * @param eventName
     * @param dateBeginning
     * @param dateEnd
     * @param quantity
     * @param team
     */
    private void addEvent(String eventName, LocalDate dateBeginning, LocalDate dateEnd, int quantity, String team ){

        Date dateDebut= Date.from(dateBeginning.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());


        Date dateFin=Date.from(dateEnd.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        dateDebut=new Timestamp(dateDebut.getTime());
        dateFin=new Timestamp(dateFin.getTime());

        System.out.println(dateDebut);
        System.out.println(dateFin);



        try {
            Event e =eventFacade.addEvent(eventName,dateDebut ,dateFin, quantity, team);
            if(e != null){
                String dateB = null;
                String dateF = null;
                SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
                try{
                    dateB = sdfr.format( e.getDateStart() );
                    dateF = sdfr.format( e.getDateEnd() );
                }catch (Exception ex ){
                    System.out.println(ex);
                }

                listEvents.getItems().add(dateB+" - "+dateF+" : "+e.getLabel());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML private void addNewEventClick(MouseEvent mouseEvent) {
        showDialogAddEvent();
    }
}
