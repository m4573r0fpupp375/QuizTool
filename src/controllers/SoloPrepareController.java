package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.CategoriesSet;
import logic.SoloGame;

public class SoloPrepareController {
    private SoloGame game;

    private MainController mainController;
    @FXML
    private TextField nicknameTextField;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;

    public SoloPrepareController() {
        game = new SoloGame();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        button1.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
        button2.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
        button3.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));

        EventHandler handler = (e) -> {
            game.setSeries(((Button) e.getSource()).getText());
        };

        button1.addEventHandler(ActionEvent.ACTION, handler);
        button2.addEventHandler(ActionEvent.ACTION, handler);
        button3.addEventHandler(ActionEvent.ACTION, handler);
    }

    @FXML
    public void backToMainMenu() {
        mainController.reinitialize();
    }
}
