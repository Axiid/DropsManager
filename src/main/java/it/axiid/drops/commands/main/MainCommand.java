package it.axiid.drops.commands.main;

import it.axiid.drops.DropsManager;
import it.axiid.drops.commands.AbstractCommand;
import it.axiid.drops.utils.BukkitPlugin;
import it.axiid.drops.utils.chat.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends AbstractCommand {

    private final DropsManager instance;

    public MainCommand(DropsManager instance) {
        super("dropsmanager", "", false);
        this.instance = instance;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(args.length != 1) {
            player.sendMessage("§b• §fRunning §bDrops§3Manager §fversion §a" + BukkitPlugin.getVersion());
            player.sendMessage("  §8» §fCreated by §eAxiid");
            return;
        }

        if(args[0].equalsIgnoreCase("reload")) {
            instance.reloadConfig();
            instance.saveConfig();

            player.sendMessage(ChatUtils.color(instance.getConfig().getString("messages.plugin-reloaded").replace("%prefix%", ChatUtils.prefix)));
            return;
        }
        player.sendMessage(ChatUtils.color(instance.getConfig().getString("messages.invalid-arguments").replace("%prefix%", ChatUtils.prefix)));
    }

}
