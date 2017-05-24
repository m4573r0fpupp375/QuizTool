package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import logic.CategoriesSet;
import logic.Game;

import java.io.IOException;

public class DuelContinueController extends PrepareController {
    private Game game;

    @FXML
    public void prepareButtons() {
        button1.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
        button2.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
        button3.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
    }

    @FXML
    public void askQuestion(ActionEvent actionEvent) {
        System.out.println(actionEvent);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DuelQuestionScreen.fxml"));
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
        DuelQuestionScreenController controller = loader.getController();
        controller.setMainController(getMainController());
        controller.setGame(game);
        getMainController().addToStackPane(pane);
    }

    public void setGame(Game game) {
        this.game = game;
        prepareButtons();
    }
}