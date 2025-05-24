package ac.kritex.listeners;

import ac.kritex.check.CheckManager;
import ac.kritex.player.KritexManager;
import ac.kritex.player.KritexPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class KritexListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        KritexPlayer player = new KritexPlayer(event.getPlayer());

        KritexManager.addPlayer(uuid, player);
        CheckManager.registerChecks(player);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        UUID uuid = event.getPlayer().getUniqueId();
        KritexPlayer player = KritexManager.getPlayer(uuid);

        if (player != null) {
            CheckManager.unregisterChecks(player);
        }
        KritexManager.removePlayer(uuid);
    }
}