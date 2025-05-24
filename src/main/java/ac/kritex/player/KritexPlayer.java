package ac.kritex.player;

import org.bukkit.entity.Player;

public class KritexPlayer {
    private final Player bukkitPlayer;

    public KritexPlayer(Player player) {
        this.bukkitPlayer = player;
    }
    public Player getPlayer() {
        return bukkitPlayer;
    }
}