package ui.inventory;

import business_logic.Article;
import business_logic.ArticleForTableView;
import facade.FacadeManager;
import facade.InventoryFacade;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import ui.ViewBridge;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class InventoryManagementController implements Initializable, ViewBridge {

    private InventoryFacade facade;
    private ObservableList<ArticleForTableView> articleData;


    @FXML private TableView<ArticleForTableView> articleTableView;


    @FXML private void addNewArticleAction(MouseEvent mouseEvent) {
        showDialogAddArticle();
    }

    @FXML private void addNewType(MouseEvent mouseEvent) {
        showAddTypeDialog();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        articleData = FXCollections.observableArrayList();
    }


    private void init(){
        for (Article a :facade.getArticlesList() ){
            System.out.print(a.getName());
            articleData.add(a.createArticleForTableView());
        }
        articleTableView.getItems().addAll(articleData);
    }

    /**
     *
     * @param article
     */
    private void addArticle(Article article){
        ObservableList<ArticleForTableView> data = articleTableView.getItems();
        data.add(article.createArticleForTableView());
    }



    private void showDialogAddArticle(){
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add new article");
        dialog.setHeaderText("Care to enter an integer in the quantity field");


        ButtonType buttonInsertArticle = new ButtonType("Insert", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonInsertArticle, ButtonType.CANCEL);


        TextField nameTF = new TextField();
        nameTF.setPromptText("Name");

        TextField descriptionTF = new TextField();
        descriptionTF.setPromptText("Description");

        TextField quantityTF = new TextField();
        quantityTF.setPromptText("Quantity");

        System.out.println(facade.getTypes());
        ObservableList options =
                FXCollections.observableArrayList(facade.getTypes());
            // load from the database


        ComboBox<String> typeCB = new ComboBox<String>(options );
        typeCB.getSelectionModel().selectFirst();


        Node submitButton = dialog.getDialogPane().lookupButton(buttonInsertArticle);
        submitButton.setDisable(true);


        nameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });

        quantityTF.textProperty().addListener( ((observable, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));

        VBox vBox = new VBox(8,nameTF,quantityTF, descriptionTF, typeCB);
        vBox.setStyle("background-color: #8080ff;" +
                "effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");

        dialog.getDialogPane().setContent(vBox);


        Platform.runLater(() -> nameTF.requestFocus());


        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonInsertArticle) {
                int quantity = Integer.parseInt(quantityTF.getText());
                String type =  typeCB.getValue();
                System.out.print(type);
                try {
                    Article a = facade.addArticle(nameTF.getText(),descriptionTF.getText(),quantity,typeCB.getValue() );
                    if(a != null){
                        addArticle(a);
                    }else{
                        return null;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        });

       dialog.showAndWait();


    }

    private void showAddTypeDialog(){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Create Type");
        dialog.setHeaderText("Please fill the field");
        dialog.setContentText("Add your new Type");


        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            if(!result.get().isEmpty() )
                facade.createType(result.get());
        }



    }





    @Override
    public void setData(FacadeManager fm, Object... p) {
        facade= fm.createInventoryFacade();
        init();
    }
}
