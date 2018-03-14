package ui;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static Stage applicationStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        applicationStage = primaryStage;
        applicationStage.getIcons().add(new Image("media/img/logo-aniki-icone.png"));
            // set the application logo
        changeScene(getClass(),"login.fxml","login");
    }

    /**
     * Allow to switch between several scene
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
     * Fade in or out a Region
     * all component extends of Region
     * a and b determine the type of fade
     * if a =1 and b= 0 fade out else if
     * a= 0 and b= 1 fade in
     * @param a
     * @param b
     * @param duration
     * @param n
     */
    public static void fadeEffect(int a, int b, int duration,Node n){
        FadeTransition ft = new FadeTransition(Duration.millis(duration), n);
        ft.setFromValue(a);
        ft.setToValue(b);
        ft.play();
    }

    public static void playSound(String filename){
        Media sound = new Media(new File(filename).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
