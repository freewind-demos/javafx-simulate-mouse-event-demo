package demo;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            Button button1 = new Button("button1: Double Click on me will say Hello to you") {{
                setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                        new Alert(Alert.AlertType.INFORMATION, "Hello!").showAndWait();
                    }
                });
            }};
            Button button2 = new Button("Simulate Double-Click event to button1") {{
                setOnAction(event -> Event.fireEvent(button1, createEvent(MouseButton.PRIMARY, 2)));
            }};
            getChildren().addAll(button1, button2);
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private MouseEvent createEvent(MouseButton button, int clickCount) {
        return new MouseEvent(MouseEvent.MOUSE_CLICKED, 0,
                0, 0, 0, button, clickCount, true, true, true, true,
                true, true, true, true, true, true, null);
    }
}