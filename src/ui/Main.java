package ui;

import facade.ExpenseFacade;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */
public class Main extends Application {

    private static Stage applicationStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        applicationStage = primaryStage;
        applicationStage.getIcons().add(new Image("media/img/logo-aniki-icone.png"));
            // set the application logo
        changeScene(getClass(),"users/login.fxml","Login");
        //changeScene(getClass(),"firstPage.fxml","homePage");
    }

    /**
     * Allows to switch between several scene
     * Has to be called every time we want to change scene
     * @param c
     * @param fxmlFile
     * @param title
     * @throws IOException
     */
    public static void changeScene(Class c,String fxmlFile, String title) throws IOException {
        Parent root = FXMLLoader.load(c.getResource(fxmlFile));
        applicationStage.setTitle(title);
        applicationStage.setScene(new Scene(root));
        applicationStage.show();
    }

    /**
     * Changes between to scene and allows to pass parameter
     * @param root
     * @param title
     */
    public static void changeScene(Parent root, String title){
        //FXMLLoader loader = new FXMLLoader(c.getResource(fxmlFile));
        //loader.getClassLoader(); ajouter une fonction pour recuperer les parametres

        applicationStage.setTitle(title);
        applicationStage.setScene(new Scene(root));
        applicationStage.show();
    }

    /**
     * Fade in or out a Region
     * all components extend of Region
     * a and b determine the type of fade
     * if a =1 and b= 0 fade out else if
     * a= 0 and b= 1 fade in
     * Nothing is done if a or b not in [0,1]
     * @param a : 0 or 1
     * @param b : 0 or 1
     * @param duration
     * @param n
     */
    public static void fadeEffect(int a, int b, int duration,Node n){
        if( a >1 || a <0 ||b >1 || b <1 ){
            FadeTransition ft = new FadeTransition(Duration.millis(duration), n);
            ft.setFromValue(a);
            ft.setToValue(b);
            ft.play();
        }

    }

    /**
     * Play a brief sound
     * @param filename : the media filename
     */
    public static void playSound(String filename){
        Media sound = new Media(new File(filename).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public static void showAlert(String title, String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        //alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText(content);

        alert.showAndWait();
    }




    public static void main(String[] args) throws SQLException {
        launch(args);

        //c.deleteLink(0, "Beach");

    }
}
