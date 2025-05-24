package ac.kritex.check.detections.movement.flight;

import ac.kritex.check.Abstract;
import ac.kritex.player.KritexPlayer;
import ac.kritex.Kritex;

public class FlightA extends Abstract {

    public FlightA(KritexPlayer player) {
        super(player, "Flight", "A");
    }

    @Override
    public String getName() {
        return "FlightA";
    }

    @Override
    public String getType() {
        return "A";
    }

    public void handle() {
        String configPath = getName() + getType() + ".enabled";
        boolean isEnabled = Kritex.getInstance().getCheckFile().getConfig().getBoolean(configPath, true);
        if (!isEnabled) return;

        if (player.getPlayer().isFlying()) {
            fail();
        }
    }
}