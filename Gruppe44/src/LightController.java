
// Kap. 14-15 brukt som inspirasjon, satt sammen og studert kode fra eksemplene i disse kapitlene.
// Brukt AI til å hjelpe med feilsøking, sette inn riktig syntaks. Både VS Code Copilot og ChatGPT er brukt.
// LightController kobler UI fra Layout.java med modellene LivingRoom og KitchenRoom.
// Layout-klassen vil kalle metodene her.
// Rammeverk bygget av Maria

import javafx.scene.Parent;

public class LightController {

    private LivingRoom livingRoom;
    private KitchenRoom kitchenRoom;

    public LightController() {
        livingRoom = new LivingRoom();
        kitchenRoom = new KitchenRoom();
    }

    
    // Kalles fra MainApp
    // Returnerer det ferdig bygde UI-et fra Layout-klassen.
     
    public Parent buildLayout() {
        Layout layout = new Layout(this);   // OK selv om Layout er tom
        return layout.createView();         // Du må legge denne inn senere Mina
    }

  
    // Living Room metoder
   

    public void turnOnLivingRoom() {
        livingRoom.getLight().setOn(true);
    }

    public void turnOffLivingRoom() {
        livingRoom.getLight().setOn(false);
    }

    public void setLivingRoomBrightness(int value) {
        livingRoom.getLight().setBrightness(value);
    }

    public Light getLivingRoomLight() {
        return livingRoom.getLight();
    }

  
    // Kitchen Room metoder
  

    public void turnOnKitchen() {
        kitchenRoom.getLight().setOn(true);
    }

    public void turnOffKitchen() {
        kitchenRoom.getLight().setOn(false);
    }

    public void setKitchenBrightness(int value) {
        kitchenRoom.getLight().setBrightness(value);
    }

    public Light getKitchenLight() {
        return kitchenRoom.getLight();
    }
}
