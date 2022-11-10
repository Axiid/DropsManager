package it.axiid.drops.commands.main;

import it.axiid.drops.DropsManager;
import it.axiid.drops.commands.AbstractCommand;
import it.axiid.drops.configuration.ConfigUtils;
import it.axiid.drops.utils.BukkitPlugin;
import it.axiid.drops.utils.chat.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends AbstractCommand {

    public MainCommand(DropsManager instance) {
        super("dropsmanager", "", false);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage("§b• §fRunning §bDrops§3Manager §fversion §a" + BukkitPlugin.getVersion());
            player.sendMessage("  §8» §fCreated by §eAxiid");
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            ConfigUtils.reloadFile();
            player.sendMessage(ChatUtils.color(ConfigUtils.getConfiguration().getString("messages.plugin-reloaded").replace("%prefix%", ChatUtils.prefix)));
            return;
        }
        player.sendMessage(ChatUtils.color(ConfigUtils.getConfiguration().getString("messages.invalid-arguments").replace("%prefix%", ChatUtils.prefix)));
    }

}
