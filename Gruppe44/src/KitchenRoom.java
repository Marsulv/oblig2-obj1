
// KitchenRoom-modellen (og LivingRoom) representerer et rom i applikasjonen som har ett lys.
// Klassen følger samme struktur som LivingRoom, som anbefalt i kapittel 14–15.
//
// Hvert rom har sin egen Light-instans, og kontrolleren (LightController)
// kommuniserer med modellen via getLight()-metoden. Dette gir en ryddig
// ansvarsfordeling (modell = controller = UI), og gjør det enkelt å legge til
// flere rom senere.
//
// Inspirasjon til strukturen: 
// * Modell-klasser fra kapittel 14: Classes and Objects
// * Eksempler på modell + controller fra kapittel 15: Event Handling
// * Egen implementasjon basert på oppgavebeskrivelsen og LivingRoom-klassen.
//
// Bygget av Maria


public class KitchenRoom {
    private Light light;

    public KitchenRoom() {
        light = new Light("Kitchen Light");
    }

    public Light getLight() {
        return light;
    }
}
