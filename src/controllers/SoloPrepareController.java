package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import logic.CategoriesSet;
import logic.Question;
import logic.SoloGame;

import java.io.IOException;

public class SoloPrepareController extends PrepareController {
    private SoloGame game;
    private String Nickname1;

    @FXML
    private TextField Player1Nickname;

    public SoloPrepareController() {
        game = new SoloGame();
    }

    @FXML
    public void initialize() {
        button1.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
        button2.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));
        button3.setText(game.banCategory(
                new CategoriesSet().getCategory(game.getBannedCategories())));

        EventHandler handler = (ev) -> {
            game.setSeries(((Button) ev.getSource()).getText());

            Nickname1 = Player1Nickname.getText();

            System.out.println("Player name: " + Nickname1);

            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Question.fxml"));
            Pane pane = null;

            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            QuestionController controller = loader.getController();
            controller.setMainController(this.getMainController());
            this.getMainController().addToStackPane(pane);
        };

        button1.addEventHandler(ActionEvent.ACTION, handler);
        button2.addEventHandler(ActionEvent.ACTION, handler);
        button3.addEventHandler(ActionEvent.ACTION, handler);
    }
}