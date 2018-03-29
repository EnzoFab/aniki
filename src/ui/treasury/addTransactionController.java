package ui.treasury;

import facade.ExpenseFacade;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.text.DateFormat;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import ui.Main;

public class addTransactionController {

    public TextField inputLabel;
    public TextField inputDate;
    public TextField inputMontant;
    public TextField inputType;

    private ExpenseFacade expensefacade;


    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        this.expensefacade = new ExpenseFacade();
    }


    public void addTransaction(ActionEvent actionEvent) throws SQLException, ParseException, IOException {
        this.expensefacade = new ExpenseFacade();
        if(!inputLabel.getText().isEmpty() && !inputDate.getText().isEmpty() && !inputMontant.getText().isEmpty() && !inputType.getText().isEmpty()){

            DateFormat formatterPG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSX");

            String dd = inputDate.getText();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateDebut=formatter.parse(dd);
            Date date=new Timestamp(dateDebut.getTime());


            expensefacade.addTransaction(inputLabel.getText(), Integer.parseInt(inputMontant.getText()),date,0,inputType.getText() );

            Main.changeScene(getClass(),"transactionManagement.fxml","Transaction Management");

        }
    }
}
