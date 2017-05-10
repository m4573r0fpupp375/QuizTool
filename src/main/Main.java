package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Main.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("QuizTool");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
