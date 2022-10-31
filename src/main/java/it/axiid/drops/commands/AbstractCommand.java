package it.axiid.drops.commands;

import it.axiid.drops.DropsManager;
import it.axiid.drops.utils.chat.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class AbstractCommand implements CommandExecutor
{

    private final DropsManager instance = DropsManager.getInstance();

    String commandName, permission;
    boolean canConsoleUse;

    public AbstractCommand(String command, String permission, boolean canConsoleUse) {
        this.commandName = command;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;

        instance.getCommand(command).setExecutor(this);
    }

    public abstract void execute(CommandSender sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!label.equalsIgnoreCase(this.commandName)) {
            return true;
        }

        if(!canConsoleUse && !(sender instanceof Player)) {
            sender.sendMessage(instance.getConfig().getString("messages.console"));
            return true;
        }

        Player player = (Player) sender;

        if(permission != null && !player.hasPermission(permission)) {
            player.sendMessage(ChatUtils.color(instance.getConfig().getString("messages.insufficient-permissions")));
            return true;
        }

        execute(sender, args);
        return true;
    }
}