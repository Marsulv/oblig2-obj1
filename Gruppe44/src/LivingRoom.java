

//inspirasjon fra kap. 14, enkle klasser og objekter
//Bygget av Maria

public class LivingRoom {
    private Light light;

    public LivingRoom() {
        light = new Light("Living Room Light");
    }

    public Light getLight() {
        return light;
    }
}
