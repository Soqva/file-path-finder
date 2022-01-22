package com.s0qva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLauncher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/root-page.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("File path finder");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
