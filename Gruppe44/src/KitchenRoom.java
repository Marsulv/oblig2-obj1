package Gruppe17.src;

//samme kode som i LivingRoom.java, bare for kjøkkenet

public class KitchenRoom {
    private Light mainLight;

    public KitchenRoom() {
        mainLight = new Light("Kitchen Room Light");
    }

    public Light getLight() {
        return mainLight;
    }
}
