package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import logic.CategoriesSet;
import logic.Game;
import logic.SoloGame;

import java.io.IOException;

public class ContinueController extends PrepareController {
    private Game game;

    public ContinueController() {
        game = new Game();
    }

    @FXML
    public void initialize() {
        button1.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
        button2.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
        button3.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
    }

    @FXML
    public void askQuestion(ActionEvent actionEvent) {
        System.out.println(actionEvent);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/QuestionScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        game.setSeries(((Button)actionEvent.getSource()).getText());
        QuestionScreenController controller = loader.getController();
        controller.setMainController(getMainController());
        controller.setGame(game);
        getMainController().addToStackPane(pane);
    }

    public void setGame(Game game) {
        this.game = game;
    }
}