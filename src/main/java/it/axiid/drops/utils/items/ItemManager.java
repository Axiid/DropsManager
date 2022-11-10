package it.axiid.drops.utils.items;

import it.axiid.drops.DropsManager;
import it.axiid.drops.api.items.ItemAPI;
import it.axiid.drops.utils.chat.ChatUtils;

public class ItemManager implements ItemAPI {

    @Override
    public boolean cantDrop() {
        return DropsManager.getInstance().getConfig().getBoolean("settings.anti-drop");
    }

    @Override
    public int getPickupDelay() {
        return DropsManager.getInstance().getConfig().getInt("settings.pickup-delay");
    }

    @Override
    public String getCustomName() {
        return ChatUtils.color(DropsManager.getInstance().getConfig().getString("settings.custom-name"));
    }


}
