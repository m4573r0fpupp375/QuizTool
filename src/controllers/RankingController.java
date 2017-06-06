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
    private LinkedList<RankRecord> rankList = new LinkedList<>();

    @FXML
    public void initialize() {
        table.setVisible(true);
        table.setEditable(false);
        table.setStyle("");

        name.setCellValueFactory(new PropertyValueFactory<RankRecord, String>("name"));
        points.setCellValueFactory(new PropertyValueFactory<RankRecord, Integer>("points"));
    }

    public void loadRank(){
        final ObservableList<RankRecord> items = FXCollections.observableArrayList();
        rankList = rankGetter.get();

        for(int i=0; i<rankList.size(); i++) {
            items.add(new RankRecord(rankList.get(i).getName(), rankList.get(i).getPoints()));
        }

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
