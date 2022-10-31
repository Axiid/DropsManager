package it.axiid.drops;

import it.axiid.drops.commands.main.MainCommand;
import it.axiid.drops.listeners.DropListeners;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
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
        registerListeners();
    }

    public void registerCommands() {
        new MainCommand(this);
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DropListeners(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }
}
