package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import logic.DuelGame;

import java.io.IOException;

public class DuelSummaryController {
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;

    @FXML
    private Label player1;
    @FXML
    private Label player2;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        button1.setText("PLAY AGAIN");
        button2.setText("RANK");
        button3.setText("EXIT");
        //player1.setText(((DuelGame)mainController.getGame()).getPlayer1());
        //player2.setText(((DuelGame)mainController.getGame()).getPlayer2());
    }

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }
    @FXML
    public void showRank(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
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
