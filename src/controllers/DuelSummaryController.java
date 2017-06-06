package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import logic.DuelGame;

import java.io.IOException;
import java.util.Objects;

public class DuelSummaryController {
    @FXML
    private Label winner;
    @FXML
    private Button button1;
    @FXML
    private Button button3;

    @FXML
    private Label player1;
    @FXML
    private Label player2;
    @FXML
    private Label score1;
    @FXML
    private Label score2;

    private DuelGame duelGame;
    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setSummary(DuelGame duelGame) {
        this.duelGame = duelGame;
        winner.setFont(Font.font(25));
        if (duelGame.getPlayer1points() > duelGame.getPlayer2points()) {
            winner.setText(duelGame.getPlayer1() + " wins!");
        } else if (Objects.equals(duelGame.getPlayer1points(), duelGame.getPlayer2points())) {
            winner.setText("Draw!");
        } else {
            winner.setText("The winner is: " + duelGame.getPlayer2() + "!");
        }
        player1.setText(duelGame.getPlayer1());
        player2.setText(duelGame.getPlayer2());
        score1.setText(duelGame.getPlayer1points() + " points");
        score2.setText(duelGame.getPlayer2points() + " points");
    }

    @FXML
    public void initialize() {
        button1.setText("PLAY AGAIN");
        button3.setText("EXIT");
    }

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }

    @FXML
    public void showRank(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/RankingScreen.fxml"));
        Pane pane = null;
        System.out.println(loader);
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RankingController controller = loader.getController();
        controller.setMainController(mainController);
//        controller.loadRank();
        mainController.addToStackPane(pane);
    }

    @FXML
    public void playAgain(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DuelPrepare.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DuelPrepareController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.addToStackPane(pane);
    }

    @FXML
    public void exitPressed(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        Platform.exit();
    }
}
