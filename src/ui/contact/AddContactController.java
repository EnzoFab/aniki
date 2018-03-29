package ui.contact;
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

public class AddContactController {

    public TextField inputName;
    public TextField inputFirstName;
    public TextField inputAdress;
    public TextField inputPhone;
    public TextField inputMail;

    private ContactFacade contactFacade;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.contactFacade = new ContactFacade();

    }

    public void addNewContact(ActionEvent actionEvent) throws SQLException, ParseException, IOException {
        this.contactFacade = new ContactFacade();
        if(!inputName.getText().isEmpty() && !inputFirstName.getText().isEmpty() && !inputAdress.getText().isEmpty() && !inputPhone.getText().isEmpty() && !inputMail.getText().isEmpty()){

            contactFacade.addContact(inputName.getText(),inputFirstName.getText(),inputAdress.getText(),inputMail.getText(),inputPhone.getText());

            Main.changeScene(getClass(),"contactManagement.fxml","Contacts Management");

        }
    }

}
