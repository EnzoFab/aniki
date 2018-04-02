package ui.contact;
import business_logic.Contact;
import facade.ContactFacade;
import facade.FacadeManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ui.ViewBridge;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ContactManagementController implements Initializable, ViewBridge{
    private ContactFacade contactFacade;

    @FXML
    private ListView<String> contactList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    @Override
    public void setData(FacadeManager fm, Object... p) {
        contactFacade= fm.createContactFacade();
        init();

    }

    private void init() {
        ArrayList<Contact> contacts = null;
        contacts = contactFacade.getContactList();

        ObservableList<String> data = FXCollections.observableArrayList();

        for (Contact E : contacts) {


            data.add(E.getFirstName()+" "+E.getName()+" : "+E.getMail()+" - "+E.getPhoneNumber()+" - "+E.getPlace());

        }

        contactList.setItems(data);
    }
}
