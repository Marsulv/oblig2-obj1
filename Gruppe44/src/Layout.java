

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Layout {

    private final LightController controller;

    // Theme flag
    private boolean darkMode = true;

    public Layout(LightController controller) {
        this.controller = controller;
    }

    public Parent createView() {

        BorderPane root = new BorderPane();
        applyTheme(root);

        // Bygg de to rommene
        VBox living = buildRoomUI(
                "Living Room",
                controller.getLivingRoomLight(),
                controller::turnOnLivingRoom,
                controller::turnOffLivingRoom,
                controller::setLivingRoomBrightness
        );

        VBox kitchen = buildRoomUI(
                "Kitchen",
                controller.getKitchenLight(),
                controller::turnOnKitchen,
                controller::turnOffKitchen,
                controller::setKitchenBrightness
        );

        // Legg de ved siden av hverandre
        HBox rooms = new HBox(40, living, kitchen);
        rooms.setAlignment(Pos.CENTER);

        // Toggle theme-knapp
        Button themeBtn = new Button("Toggle Light/Dark Mode");
        themeBtn.setOnAction(e -> {
            darkMode = !darkMode;
            applyTheme(root);
        });

        VBox bottom = new VBox(themeBtn);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(15));

        root.setCenter(rooms);
        root.setBottom(bottom);

        return root;
    }



    // Bygger GUI for ett enkelt rom
  
    private VBox buildRoomUI(
            String roomName,
            Light light,
            Runnable turnOn,
            Runnable turnOff,
            java.util.function.IntConsumer setBrightness
    ) {

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-background-color: #444; -fx-background-radius: 10;");

        Label label = new Label(roomName);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 16; -fx-font-weight: bold;");

        // Visuell lampe
        Circle lamp = new Circle(40);
        lamp.fillProperty().bind(
                javafx.beans.binding.Bindings.when(light.isOnProperty())
                        .then(Color.YELLOW)
                        .otherwise(Color.GRAY)
        );

        // Lysstyrke som opacity
        lamp.opacityProperty().bind(
                light.brightnessProperty().divide(100.0)
        );

        // Toggle ON/OFF
        Button toggle = new Button("Toggle");
        toggle.setOnAction(e -> {
            if (light.isOn()) turnOff.run();
            else turnOn.run();
        });

        // Brightness slider
        Slider slider = new Slider(0, 100, light.getBrightness());
        slider.valueProperty().addListener((o, oldVal, newVal) ->
                setBrightness.accept(newVal.intValue())
        );

        box.getChildren().addAll(label, lamp, toggle, slider);
        return box;
    }

    // Light / Dark Mode
    
    private void applyTheme(BorderPane root) {
        if (darkMode) {
            root.setStyle("-fx-background-color: #2b2b2b;");
        } else {
            root.setStyle("-fx-background-color: #eeeeee;");
        }
    }
}
