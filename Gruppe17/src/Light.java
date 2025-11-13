package Gruppe17.src;

//Dette er modellklassen for lyset i rommene

public class Light {
    private String name;
    private boolean isOn;
    private int brightness; //0-100

    public Light (String name) {
        this.name = name;
        this.isOn = false;
        this.brightness = 50; //default brightness
    }

    public void turnOn() { isOn = true; }
    public void turnOff() { isOn = false; }

    public void setBrightness(int value) {
        if (value < 0) brightness = 0;
        else if (value > 100) brightness = 100;
        else brightness = value;
    }

    public boolean isOn() { return isOn; }
    public int getBrightness() { return brightness; }
    public String getName() { return name; }
}
