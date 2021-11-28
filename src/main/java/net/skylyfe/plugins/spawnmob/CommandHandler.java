package net.skylyfe.plugins.spawnmob;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class CommandHandler implements CommandExecutor {

    String[] cmds = new String[] {
                    "spawnmob"
            };

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase(cmds[0]))

            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (!player.hasPermission("spawnmob.use")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&cYou don't have access to that command"));
                    return true; //msg handled in CommandHandler
                }

                if (CooldownHandler.CooldownChecker(player)) {
                    return true; //msg handled in CooldownHandler
                }

                if(!SpawnHandler.spawnMonster(player, args)) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Failed to spawn a mob"));
                    return true; //msg handled in CommandHandler
                }
            }

        return true;
    }
}
