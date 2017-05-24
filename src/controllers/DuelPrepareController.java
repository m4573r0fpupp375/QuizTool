package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import logic.CategoriesSet;
import logic.DuelGame;

import java.io.IOException;

/**
 * Created by Bartek on 09.05.2017. :)
 */
public class DuelPrepareController extends PrepareController {
    private DuelGame game;
    String nickname1;
    String nickname2;

    @FXML
    private TextField player1Nickname;
    @FXML
    private TextField player2Nickname;

    public DuelPrepareController() {
        game = new DuelGame();
    }

    @FXML
    public void initialize() {
        button1.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
        button2.setText(new CategoriesSet().getCategory(game.getBannedCategories()));
        button3.setText(new CategoriesSet().getCategory(game.getBannedCategories()));

        EventHandler handler = (e) -> {

            String cat = ((Button)e.getSource()).getText();
            game.setSeries(cat);
            game.getBannedCategories().removeLast();
            game.getBannedCategories().removeLast();
            game.getBannedCategories().removeLast();
            game.banCategory(cat);

            nickname1 = player1Nickname.getText();
            nickname2 = player2Nickname.getText();

            System.out.println("Players nicknames: " + nickname1 + " " + nickname2);
        };

        button1.addEventHandler(ActionEvent.ACTION, handler);
        button2.addEventHandler(ActionEvent.ACTION, handler);
        button3.addEventHandler(ActionEvent.ACTION, handler);
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

        game.setSeries(((Button)actionEvent.getSource()).getText());
        DuelQuestionScreenController controller = loader.getController();
        controller.setMainController(getMainController());
        controller.setGame(game);
        getMainController().addToStackPane(pane);
    }

    public String getNickame(int i) {
        if (i == 1) return nickname1;
        if (i == 2) return nickname2;
        return null;
    }
}
