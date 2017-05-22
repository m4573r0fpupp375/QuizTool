package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import logic.AnsState;
import logic.Game;
import logic.Question;
import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

import static java.lang.Thread.sleep;
import static logic.AnsState.GOOD;


public class QuestionScreenController {
    private Game game;
    private int questionNumber;
    private Question question;
    private boolean changingColors = true;
    private boolean nextQuestion = false;

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

        this.question = question;
        questionLabel.setText(questionNumber + 1 + ". " + question.getContent());
        ans1.setText(question.getMaskedAnswer(0));
        ans2.setText(question.getMaskedAnswer(1));
        ans3.setText(question.getMaskedAnswer(2));
        ans4.setText(question.getMaskedAnswer(3));
        questionNumber++;
    }

    @FXML
    public void setAnswer(MouseEvent actionEvent) {
        System.out.println(actionEvent);
        int tmp = 0;
        if (actionEvent.getSource() == ans1) tmp = 0;
        else if (actionEvent.getSource() == ans2) tmp = 1;
        else if (actionEvent.getSource() == ans3) tmp = 2;
        else if (actionEvent.getSource() == ans4) tmp = 3;

        question.answer(tmp);
        System.out.println(question.getState());

        if(!nextQuestion) {
            setCorespondingColor((Button) actionEvent.getSource(), question.getState());
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
        } else System.out.println("Out of questions!");
    }

    public void setGame(Game game) {
        this.game = game;
        setQuestion(game.getSeries().get(0));
    }

    @FXML
    public void setchoosen(MouseEvent mouseEvent) {
        if (!changingColors) return;
        if(mouseEvent.getSource() == ans1) ans1.setStyle("-fx-background-color:#FFCC00;");
        if(mouseEvent.getSource() == ans2) ans2.setStyle("-fx-background-color:#FFCC00;");
        if(mouseEvent.getSource() == ans3) ans3.setStyle("-fx-background-color:#FFCC00;");
        if(mouseEvent.getSource() == ans4) ans4.setStyle("-fx-background-color:#FFCC00;");
    }
    @FXML
    public void unsetchoosen(MouseEvent mouseEvent) {
        if (!changingColors) return;
        if(mouseEvent.getSource() == ans1) ans1.setStyle("");
        if(mouseEvent.getSource() == ans2) ans2.setStyle("");
        if(mouseEvent.getSource() == ans3) ans3.setStyle("");
        if(mouseEvent.getSource() == ans4) ans4.setStyle("");
    }

    public void setCorespondingColor(Button button, AnsState AS){
        button.setStyle("");
        System.out.println(button.getStyle());
        if (AS == GOOD) {
            button.setStyle("-fx-background-color:#00FF00;");
        } else {
            button.setStyle("-fx-background-color:#FF0000;");
        }
        System.out.println(button.getStyle());
    }
}
