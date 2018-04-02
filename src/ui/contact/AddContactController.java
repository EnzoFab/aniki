package ui.contact;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import facade.*;
import ui.ViewBridge;

import static ui.Main.changeScene;

public class AddContactController implements ViewBridge{

    public TextField inputName;
    public TextField inputFirstName;
    public TextField inputAdress;
    public TextField inputPhone;
    public TextField inputMail;

    private ContactFacade contactFacade;
    private FacadeManager facadeManager;




    public void addNewContact(ActionEvent actionEvent) throws SQLException, ParseException, IOException {
        if(!inputName.getText().isEmpty() && !inputFirstName.getText().isEmpty() && !inputAdress.getText().isEmpty() && !inputPhone.getText().isEmpty() && !inputMail.getText().isEmpty()){

            contactFacade.addContact(inputName.getText(),inputFirstName.getText(),inputAdress.getText(),inputMail.getText(),inputPhone.getText());

            preformBridge("contactManagement.fxml","Contacts Management");

        }
    }

    @Override
    public void setData(FacadeManager fm, Object... p) {
        facadeManager = fm ;
        contactFacade = fm.createContactFacade();

    }

    private void preformBridge( String destination, String title){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(destination));
        Parent root ;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        ViewBridge bridge = loader.getController();
        bridge.setData(facadeManager);
        changeScene(root,title);
    }

}
