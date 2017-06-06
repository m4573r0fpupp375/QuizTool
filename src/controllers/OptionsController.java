package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.lang.reflect.Array;
import java.util.*;

public class OptionsController {

    private MainController mainController;
    private HashMap<String, String> sources;

    @FXML
    private ChoiceBox<String> themeChoiceBox;

    public OptionsController() {
        sources = new HashMap<>();
        sources.put("Default Theme", "/css/DefaultTheme.css");
        sources.put("Alternative", "/css/Alternative.css");
        sources.put("Bart Skin", "/css/Bart.css");
    }

    @FXML
    public void initialize() {
        themeChoiceBox.setItems(FXCollections.observableArrayList(sources.keySet()));
        ArrayList<String> tmp = new ArrayList<>();
        tmp.addAll(sources.keySet());
        if (mainController == null) themeChoiceBox.getSelectionModel().selectFirst();
        else themeChoiceBox.getSelectionModel().select(tmp.indexOf(mainController.getCurrentSheet()));
    }

    @FXML
    public void backToMainMenu(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.reinitialize();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void applySettings(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        mainController.getMainStackPane().getStylesheets().clear();
        mainController.setCurrentSheet(themeChoiceBox.getValue());
        mainController.getMainStackPane().getStylesheets().add(sources.get(mainController.getCurrentSheet()));
        initialize();
    }
}
