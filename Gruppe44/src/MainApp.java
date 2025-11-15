

// Kap. 15: JavaFX Application. Klassen arver fra Application, fra kapittel 14 og 15.
// Dette gjør at JavaFX kan kalle start()-metoden når applikasjonen startes.
// start(Stage) setter opp hovedvinduet (primary stage) og fungerer som bindeledd mellom
// modellene (Light, Room) og brukergrensesnitt (Layout). LightController bygger på
// layout gjennom controller.buildLayout(), som følger MVC-mønsteret. (kap. 15).
// Scene-objektet inneholder alt som skal vises i vinduet.
//Rammeverk bygget av Maria

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // Oppretter controller som bygger layout
        LightController controller = new LightController();

        // Lager scene med layout fra controller
        Scene scene = new Scene(controller.buildLayout(), 600, 400);

        stage.setTitle("Fade Light, Smart Lighting Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
