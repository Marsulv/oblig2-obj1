import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class Layout {

    private LightController controller;

    public Layout(LightController controller) {
        this.controller = controller;
    }

    public Parent createView() {

        // ---------- Hovedlayout ----------
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(25));
        root.setStyle("-fx-background-color: linear-gradient(to bottom, #1f1f1f, #3a3a3a);");

        // ---------- ROM: felles metode ----------
        VBox livingUI = buildRoomUI(
                "Living Room",
                controller.getLivingRoomLight(),
                controller::turnOnLivingRoom,
                controller::turnOffLivingRoom,
                controller::setLivingRoomBrightness
        );

        VBox kitchenUI = buildRoomUI(
                "Kitchen",
                controller.getKitchenLight(),
                controller::turnOnKitchen,
                controller::turnOffKitchen,
                controller::setKitchenBrightness
        );

        // ---------- Legg rom i layout ----------
        HBox rooms = new HBox(50, livingUI, kitchenUI);
        rooms.setAlignment(Pos.CENTER);

        root.setCenter(rooms);
        return root;
    }


    // -----------------------------------------------------
    // BYGGER UI FOR ET ROM (GJENBRUKT FOR KJÃ˜KKEN OG STUE)
    // -----------------------------------------------------
    private VBox buildRoomUI(
            String labelText,
            Light light,
            Runnable turnOn,
            Runnable turnOff,
            java.util.function.IntConsumer setBrightness
    ) {

        VBox box = new VBox(15);
        box.setPadding(new Insets(20));
        box.setAlignment(Pos.CENTER);
        box.setStyle(
                "-fx-background-color: rgba(255,255,255,0.05);" +
                "-fx-border-color: #ffffff20;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"
        );

        // Label (romnavn)
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 18px; -fx-font-weight: bold;");

        // Visuelt lys
        Circle lightCircle = new Circle(60, Color.gray(0.2));

        // Fade nÃ¥r brightness endres
        lightCircle.opacityProperty().bind(light.brightnessProperty().divide(100.0));

        // Fade ved AV/PÃ…
        light.isOnProperty().addListener((obs, oldVal, newVal) -> {
            Color targetColor = newVal ? Color.YELLOW : Color.gray(0.2);

            Timeline fade = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(lightCircle.fillProperty(), lightCircle.getFill())),
                new KeyFrame(Duration.seconds(0.4),
                        new KeyValue(lightCircle.fillProperty(), targetColor))
            );
            fade.play();
        });

        // Toggle knapp
        Button toggleBtn = new Button("Toggle");
        toggleBtn.setStyle("-fx-background-color: #444; -fx-text-fill: white;");
        toggleBtn.setOnAction(e -> {
            if (light.isOn()) turnOff.run();
            else turnOn.run();
        });

        // Brightness slider
        Slider slider = new Slider(0, 100, light.getBrightness());
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setStyle("-fx-control-inner-background: #333;");
        slider.valueProperty().addListener((obs, oldVal, newVal) ->
                setBrightness.accept(newVal.intValue())
        );

        box.getChildren().addAll(label, lightCircle, toggleBtn, slider);
        return box;
    }
}
