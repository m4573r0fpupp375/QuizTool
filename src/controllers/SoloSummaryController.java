package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import logic.CategoriesSet;

import java.io.IOException;

public class SoloSummaryController {
    public Button button1;
    public Button button2;
    public Button button3;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        button1.setText("PLAY AGAIN");
        button2.setText("RANK");
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

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RankingController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.addToStackPane(pane);
    }

    @FXML
    public void playAgain(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/SoloPrepare.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SoloPrepareController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.addToStackPane(pane);
    }

    @FXML
    public void exitPressed(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        Platform.exit();
    }
}
