package com.s0qva.controller;

import com.s0qva.dto.FoundPathsDto;
import com.s0qva.service.PathfindingService;
import com.s0qva.util.ScrollPaneContainerCreator;

import com.s0qva.util.message.MessageStatus;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import java.nio.file.Path;

public class PathfindingController {
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

        Platform.runLater(() -> {
            String fileName = fileNameInputTextField.getText();
            String searchPath = directoryInputTextField.getText();
            FoundPathsDto foundPathsDto;

            if (searchPath.isEmpty()) {
                foundPathsDto = pathfindingService.getAbsolutePathToFile(fileName);
            } else {
                foundPathsDto = pathfindingService.getAbsolutePathToFile(fileName, Path.of(searchPath));
            }

            foundPathsScrollPane.setContent(null);
            foundPathsScrollPane.setContent(ScrollPaneContainerCreator.fillContainer(foundPathsDto.getFoundPaths()));
        });
    }

    @FXML
    public void clear() {
        foundPathsScrollPane.setContent(null);
        fileNameInputTextField.clear();
        directoryInputTextField.clear();
    }
}
