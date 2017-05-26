package controllers;

import com.sun.javafx.css.StyleManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.LinkedList;

public class MainController {
    private String currentSheet;

    @FXML
    private StackPane mainStackPane;

    @FXML
    public void initialize() {
        currentSheet = "Degault Theme";
        mainStackPane.getStylesheets().add("/css/DefaultTheme.css");
        reinitialize();
    }

    public void addToStackPane(Pane pane) {
        mainStackPane.getChildren().clear();
        mainStackPane.getChildren().add(pane);
    }

    public void reinitialize() {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainMenu.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        MainMenuController controller = loader.getController();
        controller.setMainController(this);
        addToStackPane(pane);
    }

    public StackPane getMainStackPane() {
        return mainStackPane;
    }

    public String getCurrentSheet() {
        return currentSheet;
    }

    public void setCurrentSheet(String currentSheet) {
        this.currentSheet = currentSheet;
    }
}