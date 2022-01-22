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
import java.util.List;

public final class ScrollPaneContainerCreator {

    private ScrollPaneContainerCreator() {
    }

    public static VBox fillContainer(List<String> values) {
        VBox container = new VBox();

        if (values.isEmpty()) {
            TextField field = createTextField(FailedMessage.FILES_NOT_FOUND.getMessage(), MessageStatus.FAILED);
            container.getChildren().add(field);

            return container;
        }

        for (String value : values) {
            TextField field = createTextField(value, MessageStatus.OK);
            container.getChildren().add(field);
        }

        addCopyMouseClickedEventToElementsInContainer(container);

        return container;
    }

    public static TextField createTextField(String value, MessageStatus status) {
        TextField field = new TextField(value);

        field.setAlignment(Pos.CENTER);
        field.setEditable(false);
        field.setPadding(new Insets(10, 10, 10, 10));
        field.setStyle("-fx-font-size: 16px;");

        if (status == MessageStatus.FAILED) {
            field.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
        }

        return field;
    }

    private static void addCopyMouseClickedEventToElementsInContainer(VBox container) {
        ObservableList<Node> paths = container.getChildren();

        for (Node path : paths) {
            path.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                ((TextField) path).copy();
            });
        }
    }
}
