package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("小姐姐，我喜欢你");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        try {
            String path = Main.class.getResource("春风十里.mp3").toURI().toString();
            Media media = new Media(path);
            MediaPlayer player =new MediaPlayer(media);
            player.play();
            //执行窗体
            launch(args);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
