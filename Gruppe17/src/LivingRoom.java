package Gruppe17.src;

//inspirasjon fra kap. 14, enkle klasser og objekter

public class LivingRoom {
    private Light mainLight;

    public LivingRoom() {
        mainLight = new Light("Living Room Light");
    }

    public Light getLight() {
        return mainLight;
    }
}
