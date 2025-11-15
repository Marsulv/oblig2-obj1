
//Dette Light, hvor man bruker binding til Layout.java. 
//GUI-et kan dermed oppdatere seg selv når modellens tilstand endres.
//For eksempel: når lyset skrus på, endres en property, og GUI-et oppdateres automatisk.
//Inspirert av kapittel 14,15 og 16, spesielt binding-delen i kap.16.
//Bygget av Maria

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Light {

    private String name;

    private BooleanProperty isOn = new SimpleBooleanProperty(false);
    private IntegerProperty brightness = new SimpleIntegerProperty(50);

    public Light(String name) {
        this.name = name;
    }

    // Properties
    public BooleanProperty isOnProperty() {
        return isOn;
    }

    public IntegerProperty brightnessProperty() {
        return brightness;
    }

    // Convenience metoder, ikke nødvendig, men vanlig å ha.
    public boolean isOn() {
        return isOn.get();
    }

    public void setOn(boolean value) {
        isOn.set(value);
    }

    public int getBrightness() {
        return brightness.get();
    }

    public void setBrightness(int value) {
        if (value < 0) brightness.set(0);
        else if (value > 100) brightness.set(100);
        else brightness.set(value);
    }

    public String getName() {
        return name;
    }
}
