package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.concurrent.ThreadLocalRandom;

public class Controller {

    @FXML
    public Button agreeBtn;
    @FXML
    public Button disagreeBtn;
    @FXML
    public Label msg;

    @FXML
    protected void agree(){
        msg.setOpacity(1);
    }

    @FXML
    protected void disagree(){
        int x = ThreadLocalRandom.current().nextInt(600);
        int y = ThreadLocalRandom.current().nextInt(400);
        disagreeBtn.setLayoutX(x);
        disagreeBtn.setLayoutY(y);
    }
}
