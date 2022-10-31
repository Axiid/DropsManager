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

        if(!ItemAPI.canDrop()) {
            player.sendMessage(ChatUtils.color(instance.getConfig().getString("messages.cant-drop")));
            event.setCancelled(true);
            return;
        }

        if(!ItemAPI.isGlowing()) {
            event.getItemDrop().setGlowing(true);
        }

        if(!ItemAPI.getCustomName().equals("")) {
            ItemMeta item = event.getItemDrop().getItemStack().getItemMeta();
            item.setDisplayName(ChatUtils.color(instance.getConfig().getString("settings.custom-name")));
            event.getItemDrop().getItemStack().setItemMeta(item);
        }

        event.getItemDrop().setPickupDelay(instance.getConfig().getInt("settings.pickup-delay"));

    }

}
