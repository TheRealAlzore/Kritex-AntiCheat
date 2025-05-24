package ac.kritex.check;

import ac.kritex.Kritex;
import ac.kritex.player.KritexPlayer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CheckInfo {

    private final KritexPlayer kritexPlayer;
    private final String baseName;
    private final String type;
    private int violation;

    public CheckInfo(KritexPlayer kritexPlayer, String baseName, String type) {
        this.kritexPlayer = kritexPlayer;
        this.baseName = baseName;
        this.type = type;
        this.violation = 0;
    }

    public void fail() {
        FileConfiguration checks = Kritex.getInstance().getCheckFile().getConfig();
        String fullCheckName = baseName + type;

        if (!checks.getBoolean(fullCheckName + ".enabled", true)) return;

        violation++;

        int maxViolation = checks.getInt(fullCheckName + ".violation", 5);
        String messageTemplate = checks.getString("flag-message", "&c[&4Kritex&c] &7%player% failed %check% [%type%] (VL: %vl%)");

        String message = messageTemplate
                .replace("%player%", kritexPlayer.getPlayer().getName())
                .replace("%vl%", String.valueOf(violation))
                .replace("%check%", baseName)
                .replace("%type%", type);

        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.hasPermission("kritex.alerts")) {
                online.sendMessage(message);
            }
        }

        if (violation >= maxViolation) {
            String punishmentCommand = checks.getString(fullCheckName + ".punishment", "kick %player% Cheating")
                    .replace("%player%", kritexPlayer.getPlayer().getName());

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), punishmentCommand);
        }
    }
    public int getViolation() {
        return violation;
    }
    public void resetViolations() {
        this.violation = 0;
    }
}