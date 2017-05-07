package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OptionsController {

    private MainController mainController;

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
