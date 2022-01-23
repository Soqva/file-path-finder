package com.s0qva.util;

import com.s0qva.util.message.FailedMessage;
import com.s0qva.util.message.MessageStatus;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public final class ScrollPaneContainerCreator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScrollPaneContainerCreator.class);

    private ScrollPaneContainerCreator() {
    }

    public static VBox fillContainer(List<String> values) {
        VBox container = new VBox();
        LOGGER.info("The container {} is being creating", container);

        if (values.isEmpty()) {
            TextField field = createTextField(FailedMessage.FILES_NOT_FOUND.getMessage(), MessageStatus.FAILED);
            container.getChildren().add(field);
            LOGGER.info("Field {} has been added to the container", container);

            LOGGER.info("The container {} has been created and it does not contain any paths", container);
            return container;
        }

        for (String value : values) {
            TextField field = createTextField(value, MessageStatus.OK);
            container.getChildren().add(field);
            LOGGER.info("Field {} has been added to the container", container);
        }

        LOGGER.info("Copy mouse clicked event for each field is being processed");
        addCopyMouseClickedEventToElementsInContainer(container);
        LOGGER.info("Copy mouse clicked event for each field has been finished");

        LOGGER.info("The container {} has been created and it contains some paths", container);
        return container;
    }

    public static TextField createTextField(String value, MessageStatus status) {
        TextField field = new TextField(value);
        LOGGER.info("Filed {} is being created", field);

        field.setAlignment(Pos.CENTER);
        field.setEditable(false);
        field.setPadding(new Insets(10, 10, 10, 10));
        field.setStyle("-fx-font-size: 16px;");

        if (status == MessageStatus.FAILED) {
            field.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        }

        LOGGER.info("Filed {} has been created", field);
        return field;
    }

    private static void addCopyMouseClickedEventToElementsInContainer(VBox container) {
        ObservableList<Node> paths = container.getChildren();

        for (Node path : paths) {
            LOGGER.info("Copy mouse clicked event for {} is being processed", path);
            path.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                ((TextField) path).copy();
            });
            LOGGER.info("Copy mouse clicked event for {} has been finished", path);
        }
    }
}
