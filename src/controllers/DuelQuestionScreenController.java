package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import logic.AnsState;
import logic.Game;
import logic.Question;

import java.io.IOException;

import static javafx.scene.input.KeyCode.*;
import static logic.AnsState.GOOD;

public class DuelQuestionScreenController {
    private Game game;
    private int questionNumber;
    private Question question;
    private boolean changingColors = true;
    private boolean nextQuestion = false;

    @FXML
    public Label setLabel;
    @FXML
    public Label qLabel;
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
        ans1.setStyle("");
        ans2.setStyle("");
        ans3.setStyle("");
        ans4.setStyle("");

        qLabel.setText("Q: " + (questionNumber + 1) + " / 5");
        this.question = question;
        questionLabel.setText(question.getContent());
        ans1.setText(question.getMaskedAnswer(0));
        ans2.setText(question.getMaskedAnswer(1));
        ans3.setText(question.getMaskedAnswer(2));
        ans4.setText(question.getMaskedAnswer(3));
        questionNumber++;
    }

    @FXML
    public void setAnswer(KeyEvent keyEvent) {
        boolean keycheck = false;
        KeyCode[] tab = {KeyCode.Q, KeyCode.W, KeyCode.A, KeyCode.S, KeyCode.O, KeyCode.P, KeyCode.K, KeyCode.L};
        for(int i=0; i<8; i++){
            if(keyEvent.getCode() == tab[i]) keycheck = true;
        }
        if(!keycheck) return;

        System.out.println(keyEvent.getCode());
        Button id = ans1;

        int tmp = 0;
        if (keyEvent.getCode() == tab[0] || keyEvent.getCode() == tab[4]) {
            tmp = 0;
            id = ans1;
        }
        else if (keyEvent.getCode() == tab[1] || keyEvent.getCode() == tab[5]) {
            tmp = 1;
            id = ans2;
        }
        else if (keyEvent.getCode() == tab[2] || keyEvent.getCode() == tab[6]) {
            tmp = 2;
            id = ans3;
        }
        else if (keyEvent.getCode() == tab[3] || keyEvent.getCode() == tab[7]) {
            tmp = 3;
            id = ans4;
        }

        question.answer(tmp);
        System.out.println(question.getState());

        if(!nextQuestion) {
            System.out.println(keyEvent.getSource());
            setCorrespondingColor(id, question.getState());
            changingColors = false;
            nextQuestion = true;
        }
        else {
            loadNextQuestion();
            changingColors = true;
            nextQuestion = false;
        }
    }

    public void loadNextQuestion() {
        if (questionNumber < game.getSeries().size()) {
            setQuestion(game.getSeries().get(questionNumber));
        } else {
            System.out.println("Out of questions! Continuing...");
            game.incrementSeriesNo();

            if (game.getSeriesNo() == 3) {
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainMenu.fxml"));
                Pane pane = null;

                try {
                    pane = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                MainMenuController controller = loader.getController();
                controller.setMainController(mainController);
                mainController.addToStackPane(pane);
            }
            else {
                FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DuelContinue.fxml"));
                Pane pane = null;

                try {
                    pane = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DuelContinueController controller = loader.getController();
                controller.setMainController(mainController);
                controller.setGame(game);
                mainController.addToStackPane(pane);
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
        setQuestion(game.getSeries().get(0));
        setLabel.setText("Set: " + (game.getSeriesNo() + 1) + " / 3");
        qLabel.setText("Q: 1 / 5");
    }


    public void setCorrespondingColor(Button button, AnsState AS){
        button.setStyle("");
        System.out.println(button.getStyle());
        if (AS == GOOD) {
            button.setStyle("-fx-background-color:#9aee7d");
        } else {
            button.setStyle("-fx-background-color:#ff7581;");
        }
        System.out.println(button.getStyle());
    }
}
