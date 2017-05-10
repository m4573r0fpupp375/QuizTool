package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import logic.Game;
import logic.Question;

public class QuestionScreenController {
    private Game game;
    private int questionNumber;
    private Question question;

    @FXML
    private Button ans3;
    @FXML
    private Button ans4;
    @FXML
    private Button ans1;
    @FXML
    private Button ans2;
    @FXML
    private Label questionLabel;

    private MainController mainController;

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        questionLabel.setWrapText(true);
        ans1.setWrapText(true);
        ans2.setWrapText(true);
        ans3.setWrapText(true);
        ans4.setWrapText(true);
        questionNumber = 0;
    }

    public void setQuestion(Question question) {
        this.question = question;
        questionLabel.setText(questionNumber + 1 + ". " + question.getContent());
        ans1.setText(question.getMaskedAnswer(0));
        ans2.setText(question.getMaskedAnswer(1));
        ans3.setText(question.getMaskedAnswer(2));
        ans4.setText(question.getMaskedAnswer(3));
        questionNumber++;
    }

    @FXML
    public void setAnswer(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        int tmp = 0;
        if (actionEvent.getSource() == ans1) tmp = 0;
        else if (actionEvent.getSource() == ans2) tmp = 1;
        else if (actionEvent.getSource() == ans3) tmp = 2;
        else if (actionEvent.getSource() == ans4) tmp = 3;

        question.answer(tmp);
        System.out.println(question.getState());

        if (questionNumber < game.getSeries().size()) {
            setQuestion(game.getSeries().get(questionNumber));
        } else System.out.println("Out of questions!");
    }

    public void setGame(Game game) {
        this.game = game;
        setQuestion(game.getSeries().get(0));
    }
}
