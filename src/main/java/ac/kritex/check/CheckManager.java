package ac.kritex.check;

import ac.kritex.player.KritexPlayer;
import ac.kritex.check.detections.movement.flight.FlightA;
import ac.kritex.check.packet.PacketCheck;

import java.util.*;

public class CheckManager {

    private static final Map<UUID, List<Abstract>> checks = new HashMap<>();

    public static void registerChecks(KritexPlayer player) {
        List<Abstract> playerChecks = new ArrayList<>();

        playerChecks.add(new FlightA(player));

        for (Abstract check : playerChecks) {
            if (check instanceof PacketCheck) {
                ((PacketCheck) check).onEnable();
            }
        }

        checks.put(player.getPlayer().getUniqueId(), playerChecks);
    }

    public static void unregisterChecks(KritexPlayer player) {
        UUID uuid = player.getPlayer().getUniqueId();

        List<Abstract> playerChecks = checks.remove(uuid);
        if (playerChecks != null) {
            for (Abstract check : playerChecks) {
                if (check instanceof PacketCheck) {
                    ((PacketCheck) check).onDisable();
                }
            }
        }
    }

    public static List<Abstract> getPlayerChecks(UUID uuid) {
        return checks.getOrDefault(uuid, Collections.emptyList());
    }

    public static Collection<List<Abstract>> getAllChecks() {
        return checks.values();
    }
}