package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import logic.RankGetter;

/**
 * Created by Bartek on today. :)
 */
public class RankingController {
    @FXML
    private TableView rank;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn points;

    private MainController mainController;
    private RankGetter rankGetter;

    @FXML
    public void initialize() {
        rank.setVisible(true);
        //player1.setText(((DuelGame)mainController.getGame()).getPlayer1());
        //player2.setText(((DuelGame)mainController.getGame()).getPlayer2());
    }

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
