package it.axiid.drops.listeners;

import it.axiid.drops.configuration.ConfigUtils;
import it.axiid.drops.utils.chat.ChatUtils;
import it.axiid.drops.utils.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class DropListeners implements Listener {

    ItemManager itemManager = new ItemManager();

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        String itemName = event.getItemDrop().getItemStack().getType().toString().replace('_', ' ').toLowerCase();
        String finalItemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);

        if (itemManager.cantDrop()) {
            player.sendMessage(ChatUtils.color(ConfigUtils.getConfiguration().getString("messages.cant-drop").replace("%prefix%", ChatUtils.prefix)));
            event.setCancelled(true);
            return;
        }

        if (!(itemManager.getCustomName()).equals("")) {
            ItemMeta item = event.getItemDrop().getItemStack().getItemMeta();
            item.setDisplayName(ChatUtils.color(ConfigUtils.getConfiguration().getString("settings.custom-name")
                    .replace("%prefix%", ChatUtils.prefix)
                    .replace("%item%", finalItemName)
            ));
            event.getItemDrop().getItemStack().setItemMeta(item);
        }

        event.getItemDrop().setPickupDelay(ConfigUtils.getConfiguration().getInt("settings.pickup-delay"));

    }

}
