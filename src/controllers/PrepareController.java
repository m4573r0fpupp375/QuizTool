package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrepareController {
    private MainController mainController;

    @FXML
    protected Button button1;
    @FXML
    protected Button button2;
    @FXML
    protected Button button3;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {return mainController;}

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }
}
