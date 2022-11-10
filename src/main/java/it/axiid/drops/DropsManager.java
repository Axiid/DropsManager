package it.axiid.drops;

import it.axiid.drops.commands.main.MainCommand;
import it.axiid.drops.listeners.DropListeners;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DropsManager extends JavaPlugin {

    private static DropsManager instance;

    public static DropsManager getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        registerCommands();
        registerListeners(new DropListeners());
    }

    private void registerCommands() {
        new MainCommand(this);
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }
}
