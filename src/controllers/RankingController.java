package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.RankGetter;
import logic.RankRecord;
import java.util.LinkedList;

public class RankingController {
    @FXML
    private TableView<RankRecord> table;
    @FXML
    private TableColumn<RankRecord, String> name;
    @FXML
    private TableColumn<RankRecord, Integer> points;

    private MainController mainController;
    private RankGetter rankGetter = new RankGetter();

    @FXML
    public void initialize() {
        table.setVisible(true);
        table.setEditable(false);
        table.setSelectionModel(null);

        name.impl_setReorderable(false);
        name.setResizable(false);
        name.setSortable(false);
        name.setEditable(false);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        points.impl_setReorderable(false);
        points.setResizable(false);
        points.setSortable(false);
        points.setEditable(false);
        points.setCellValueFactory(new PropertyValueFactory<>("points"));
    }

    public void loadRank(){
        LinkedList<RankRecord> rankList = rankGetter.get();
        final ObservableList<RankRecord> items = FXCollections.observableArrayList();
        items.addAll(rankList);

        table.setItems(items);
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
