package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.CategoriesSet;
import logic.Game;

/**
 * Created by Bartek on 09.05.2017. :)
 */
public class PrepareController {
    private MainController mainController;

    @FXML
    protected Button button1;
    @FXML
    protected Button button2;
    @FXML
    protected Button button3;

    public PrepareController(){}

    @FXML
    public void initialize() {}

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public MainController getMainController() {return mainController;}

    @FXML
    public void backToMainMenu() {
        mainController.reinitialize();
    }
}
