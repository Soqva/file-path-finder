package com.s0qva.controller;

import com.s0qva.dto.FoundPathsDto;
import com.s0qva.service.PathfindingService;
import com.s0qva.util.ScrollPaneContainerCreator;
import com.s0qva.util.message.MessageStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;

public class PathfindingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PathfindingController.class);
    private static final PathfindingService pathfindingService = PathfindingService.getInstance();
    @FXML
    ScrollPane foundPathsScrollPane;
    @FXML
    TextField fileNameInputTextField;
    @FXML
    TextField directoryInputTextField;

    @FXML
    public void findAbsolutePaths() {
        foundPathsScrollPane.setContent(ScrollPaneContainerCreator.createTextField("Searching...", MessageStatus.OK));
        LOGGER.info("Method findAbsolutePaths is being processed");

        Platform.runLater(() -> {
            String fileName = fileNameInputTextField.getText();
            String searchPath = directoryInputTextField.getText();
            LOGGER.info("File name {} and search path {} have been received", fileName, searchPath);
            FoundPathsDto foundPathsDto;

            if (searchPath.isEmpty()) {
                LOGGER.info("Search path {} is empty", searchPath);
                LOGGER.info("Method getAbsolutePathToFile({}) is being processed", fileName);
                foundPathsDto = pathfindingService.getAbsolutePathToFile(fileName);
                LOGGER.info("Method getAbsolutePathToFile({}) has been finished", fileName);
            } else {
                LOGGER.info("Method getAbsolutePathToFile({}, {}) is being processed", fileName, searchPath);
                foundPathsDto = pathfindingService.getAbsolutePathToFile(fileName, Path.of(searchPath));
                LOGGER.info("Method getAbsolutePathToFile({}, {}) has been finished", fileName, searchPath);
            }

            LOGGER.info("The content of scroll pane is being updated");
            foundPathsScrollPane.setContent(null);
            foundPathsScrollPane.setContent(ScrollPaneContainerCreator.fillContainer(foundPathsDto.getFoundPaths()));
            LOGGER.info("Method findAbsolutePaths has been finished");
        });
    }

    @FXML
    public void clear() {
        LOGGER.info("Method clear is being processed");
        foundPathsScrollPane.setContent(null);
        fileNameInputTextField.clear();
        directoryInputTextField.clear();
        LOGGER.info("Method clear has been finished");
    }
}
