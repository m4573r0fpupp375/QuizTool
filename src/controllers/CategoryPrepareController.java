package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.CategoriesSet;

/**
 * Created by Bartek on 09.05.2017. :)
 */
public class CategoryPrepareController {
    protected MainController mainController;

    @FXML
    protected Button button1;
    @FXML
    protected Button button2;
    @FXML
    protected Button button3;

    public  CategoryPrepareController(){}

    @FXML
    public void initialize() {
        //todo for Mikolaj
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void backToMainMenu() {
        mainController.reinitialize();
    }
}
