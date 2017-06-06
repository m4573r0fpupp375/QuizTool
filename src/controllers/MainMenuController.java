package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class MainMenuController {

    public Button solo;
    public Button duel;
    public Button options;
    public Button exit;

    private MainController mainController;

    @FXML
    public void soloPressed(ActionEvent actionEvent) {
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
    public void duelPressed(ActionEvent actionEvent) {
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
        controller.loadRank();
        mainController.addToStackPane(pane);
    }

    @FXML
    public void optionsPressed(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Options.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OptionsController controller = loader.getController();
        controller.setMainController(mainController);
        mainController.addToStackPane(pane);
    }

    @FXML
    public void exitPressed(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        Platform.exit();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
