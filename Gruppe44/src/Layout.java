
// eksempel på fading, når man bruker binding (kap.16)
livingCircle.opacityProperty().bind(
    controller.getLivingRoomLight()
             .brightnessProperty()
             .divide(100.0)
);

//og eksempel på slider:
brightnessSlider.valueProperty().addListener((obs, o, n) ->
    controller.getLivingRoomLight().setBrightness(n.intValue())
);
// Binding ønsker Steven at vi skal bruke som jeg skjønte det? Det er fancy greier. 


public class Layout {
    
}
