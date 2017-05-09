package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.CategoriesSet;
import logic.Question;

/**
 * Created by Bartek on 09.05.2017. :)
 */
public class QuestionController {
    private Question quest;

    @FXML
    protected Button button1;
    @FXML
    protected Button button2;
    @FXML
    protected Button button3;
    @FXML
    protected Button button4;
    private MainController mainController;

    public QuestionController (Question question){
        quest = question;
    }

    @FXML
    public void initialize() {
        button1.setText(quest.getAnswer(1));
        button2.setText(quest.getAnswer(2));
        button3.setText(quest.getAnswer(3));
        button4.setText(quest.getAnswer(4));

        /*EventHandler handler = (e) -> {
            game.setSeries(((Button) e.getSource()).getText());
        };*/
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
