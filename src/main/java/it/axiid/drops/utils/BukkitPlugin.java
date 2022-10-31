package it.axiid.drops.utils;

import it.axiid.drops.DropsManager;

public class BukkitPlugin {

    private static final DropsManager instance = DropsManager.getInstance();

    public static String getVersion() {
        return instance.getDescription().getVersion();
    }

}