package it.axiid.drops.listeners;

import it.axiid.drops.DropsManager;
import it.axiid.drops.api.items.ItemAPI;
import it.axiid.drops.utils.chat.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class DropListeners implements Listener
{

    private final DropsManager instance;

    public DropListeners(DropsManager instance) {
        this.instance = instance;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        String itemName = event.getItemDrop().getItemStack().getType().toString().replace('_', ' ').toLowerCase();
        String finalItemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);

        if(ItemAPI.cantDrop()) {
            player.sendMessage(ChatUtils.color(instance.getConfig().getString("messages.cant-drop").replace("%prefix%", ChatUtils.prefix)));
            event.setCancelled(true);
            return;
        }

        if(!ItemAPI.getCustomName().equals("")) {
            ItemMeta item = event.getItemDrop().getItemStack().getItemMeta();
            item.setDisplayName(ChatUtils.color(instance.getConfig().getString("settings.custom-name")
                    .replace("%prefix%", ChatUtils.prefix)
                    .replace("%item%", finalItemName)
            ));
            event.getItemDrop().getItemStack().setItemMeta(item);
        }

        event.getItemDrop().setPickupDelay(instance.getConfig().getInt("settings.pickup-delay"));

    }

}
