package ac.kritex;

import ac.kritex.files.CheckFile;
import ac.kritex.files.ConfigFile;
import ac.kritex.listeners.KritexListener;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kritex extends JavaPlugin {

    private static Kritex instance;
    private final ConfigFile configFile = new ConfigFile();
    private final CheckFile checkFile = new CheckFile();
    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        instance = this;

        configFile.setup();
        checkFile.setup();

        protocolManager = ProtocolLibrary.getProtocolManager();
        PacketHandler.register(protocolManager);

        registerListeners();

        getLogger().info("Kritex Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Kritex Disabled");
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new KritexListener(), this);
    }

    public static Kritex getInstance() {
        return instance;
    }

    public ConfigFile getConfigFile() {
        return configFile;
    }

    public CheckFile getCheckFile() {
        return checkFile;
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }
}