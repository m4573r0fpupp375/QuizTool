package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import logic.CategoriesSet;
import logic.Game;

import java.io.IOException;

public class ContinueController extends PrepareController {
    private Game game;

    public void prepareButtons() {
        button1.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
        button2.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
        button3.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
    }

    @FXML
    public void askQuestion(ActionEvent actionEvent) {
        System.out.println(actionEvent);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/SoloQuestionScreen.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cat = ((Button)actionEvent.getSource()).getText();
        game.setSeries(cat);
        game.getBannedCategories().removeLast();
        game.getBannedCategories().removeLast();
        game.getBannedCategories().removeLast();
        game.banCategory(cat);
        SoloQuestionScreenController controller = loader.getController();
        controller.setMainController(getMainController());
        controller.setGame(game);
        getMainController().addToStackPane(pane);
        System.out.println(game.getBannedCategories());
    }

    public void setGame(Game game) {
        this.game = game;
        prepareButtons();
    }
}