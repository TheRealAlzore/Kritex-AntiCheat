package ac.kritex.player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KritexManager {
    private static final Map<UUID, KritexPlayer> players = new HashMap<>();

    public static void addPlayer(UUID uuid, KritexPlayer player) {
        players.put(uuid, player);
    }
    public static void removePlayer(UUID uuid) {
        players.remove(uuid);
    }
    public static KritexPlayer getPlayer(UUID uuid) {
        return players.get(uuid);
    }
    public static boolean hasPlayer(UUID uuid) {
        return players.containsKey(uuid);
    }
    public static Map<UUID, KritexPlayer> getAllPlayers() {
        return players;
    }
}