package ui.inventory;

import facade.FacadeManager;
import facade.InventoryFacade;
import javafx.fxml.Initializable;
import ui.ViewBridge;

import java.net.URL;
import java.util.ResourceBundle;

public class AddArticleController implements Initializable, ViewBridge{
    private FacadeManager facadeManager;
    private InventoryFacade facade;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setData(FacadeManager fm) {
        facadeManager = fm;
        facade= facadeManager.createInventoryFacade();
    }
}
