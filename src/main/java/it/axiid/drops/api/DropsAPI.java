package it.axiid.drops.api;

import it.axiid.drops.DropsManager;
import it.axiid.drops.utils.BukkitPlugin;
import it.axiid.drops.utils.chat.ChatUtils;

public interface DropsAPI {

    static String getVersion() {
        return BukkitPlugin.getVersion();
    }

    static String getPrefix() {
        return ChatUtils.color(DropsManager.getInstance().getConfig().getString("prefix"));
    }

}
