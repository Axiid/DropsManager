package it.axiid.drops.configuration;

import it.axiid.drops.DropsManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigUtils {

    private static final DropsManager instance = DropsManager.getInstance();
    private static FileConfiguration configuration;

    private static final File file = new File(DropsManager.getInstance().getDataFolder(), "config.yml");

    public static FileConfiguration getConfiguration() {
        return configuration;
    }

    public static void reloadFile() {
        configuration = YamlConfiguration.loadConfiguration(file);
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile() {
        try {
            configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
