package com.s0qva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLauncher extends Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLauncher.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LOGGER.info("The application is starting...");
        LOGGER.info("Loading root-page.fxml");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/root-page.fxml"));
        LOGGER.info("Loading root-page.fxml has been successfully finished: {}", root);
        LOGGER.info("Scene is being created");
        Scene scene = new Scene(root);
        LOGGER.info("Scene {} has been created", scene);

        LOGGER.info("Some options for the stage");
        stage.setTitle("File path finder");
        stage.setResizable(false);
        LOGGER.info("Scene {} is being set to the stage {}", scene, stage);
        stage.setScene(scene);
        LOGGER.info("Scene {} has been successfully set to the stage {}", scene, stage);
        stage.show();
        LOGGER.info("Stage {} is being showed", stage);
    }
}
