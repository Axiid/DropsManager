package it.axiid.drops.utils;

import it.axiid.drops.DropsManager;

public class BukkitPlugin {

    public static String getVersion() {
        return DropsManager.getInstance().getDescription().getVersion();
    }

}