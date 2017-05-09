package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.CategoriesSet;
import logic.DuelGame;

/**
 * Created by Bartek on 09.05.2017. :)
 */
public class DuelPrepareController extends PrepareController{
    private DuelGame game;
    String Nickname1, Nickname2;

    @FXML
    private TextField Player1Nickname;
    @FXML
    private TextField Player2Nickname;

    public DuelPrepareController(){game = new DuelGame();}

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

            Nickname1 = Player1Nickname.getText();
            Nickname2 = Player2Nickname.getText();

            System.out.println("Players nicknames: "+Nickname1+" "+Nickname2);
        };

        button1.addEventHandler(ActionEvent.ACTION, handler);
        button2.addEventHandler(ActionEvent.ACTION, handler);
        button3.addEventHandler(ActionEvent.ACTION, handler);
    }

    public String getNickame(int i){
        if(i == 1) return Nickname1;
        return Nickname2;
    }
}
