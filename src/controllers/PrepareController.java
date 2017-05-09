package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Bartek on 09.05.2017. :)
 */
public class PrepareController {

    protected MainController mainController;

    @FXML
    protected Button button1;
    @FXML
    protected Button button2;
    @FXML
    protected Button button3;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void backToMainMenu() {
        mainController.reinitialize();
    }
}
