package ac.kritex.files;

import ac.kritex.Kritex;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigFile {

    private File file;
    private FileConfiguration config;

    public void setup() {
        file = new File(Kritex.getInstance().getDataFolder(), "config.yml");

        if (!file.exists()) {
            Kritex.getInstance().saveResource("config.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(file);
    }
}