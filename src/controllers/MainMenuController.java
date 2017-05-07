package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainMenuController {

    private MainController mainController;

    @FXML
    public void soloPressed(ActionEvent actionEvent) {
        System.out.println(actionEvent);
    }

    @FXML
    public void duelPressed(ActionEvent actionEvent) {
        System.out.println(actionEvent);
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
