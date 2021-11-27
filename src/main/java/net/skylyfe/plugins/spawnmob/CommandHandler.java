package net.skylyfe.plugins.spawnmob;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class CommandHandler implements CommandExecutor {
    /**
     * Checks if the command is phrased correctly if so runs it and returns true else return false
     * @param sender
     * @param cmd
     * @param label
     * @param args
     * @return boolean
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        //Checks if the command is by, a player or command prompt and console
        if (sender instanceof Player) {
            Player p = (Player) sender;

            //checks if there is a mob input (/spawnmob "zombie") = 1 | (/spawnmob ) = 0
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Syntax: /spawnmob <entity>"));
                return true;
            }

            //If the player targets another player /spawnmob "xxx" "xxx" "otherPlayerName"
            Location location = p.getLocation();
            if (args.length >= 3){
                Player targetPlayer = getServer().getPlayer(args[2]);
                location = targetPlayer.getLocation();
            }

            //As a base if not specefied monsters spawned will be 1. If the specefication is below 8(current limit) it will spawn that number else it will be 8
            int quantityMobs = 1;
            if (args.length >= 2){
                quantityMobs = Integer.parseInt(args[1]);
                if(Integer.parseInt(args[1]) > 8){
                    quantityMobs = 8; //if the quantityOfMonsters is > 8 then just spawn 8. (Change to config later)
                }
            }


            //Checkes the monster the player wants to spawn (/spawnmob "zombie" "xxx" "xxx") and spawns it if spelled correctly (not case sensitive)
            switch (args[0].toUpperCase()) {
                case "ZOMBIE":
                    SpawnHandler.spawnMonster(p,location,quantityMobs,EntityType.ZOMBIE);
                    break;

                case "SKELETON":
                    SpawnHandler.spawnMonster(p,location,quantityMobs,EntityType.SKELETON);
                    break;

                case "ENDERMAN":
                    SpawnHandler.spawnMonster(p,location,quantityMobs,EntityType.ENDERMAN);
                    break;

                default:
                    return false;
            }
        }

        return true;
    }
}
