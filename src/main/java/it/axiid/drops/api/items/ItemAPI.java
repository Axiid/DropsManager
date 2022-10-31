package it.axiid.drops.api.items;

import it.axiid.drops.DropsManager;
import it.axiid.drops.utils.chat.ChatUtils;

public interface ItemAPI
{

    static boolean isGlowing() {
        return DropsManager.getInstance().getConfig().getBoolean("settings.glowing");
    }

    static boolean canDrop() {
        return DropsManager.getInstance().getConfig().getBoolean("settings.cant-drop");
    }

    static int getPickupDelay() {
        return DropsManager.getInstance().getConfig().getInt("settings.pickup-delay");
    }

    static String getCustomName() {
        return ChatUtils.color(DropsManager.getInstance().getConfig().getString("settings.custom-name"));
    }

}
