package it.axiid.drops.utils.chat;

import it.axiid.drops.DropsManager;
import org.bukkit.ChatColor;

public class ChatUtils {

    private static final DropsManager instance = DropsManager.getInstance();

    public static String prefix = color(instance.getConfig().getString("prefix"));

    public static String color(String path) {
        return ChatColor.translateAlternateColorCodes('&', path);
    }

}
