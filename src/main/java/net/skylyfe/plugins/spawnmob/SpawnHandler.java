package net.skylyfe.plugins.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class SpawnHandler {

    public static boolean spawnMonster(Player player, String[] args){
        if (args.length < 1) return true;

        String monster = args[0];
        EntityType EntityMonster = EntityType.valueOf(monster.toUpperCase());

        Location targetLocation = player.getLocation();
        int quantity = 1;

        if (args.length >= 3) {
            targetLocation = getServer().getPlayer(args[2]).getLocation();
        }

        if (args.length >= 2) {
            try {
            quantity = Integer.parseInt(args[1]);
            } catch (Exception e) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&cInvalid amount"));
                return true;
            }
            if (quantity < 1 || quantity > 4) {
                quantity = 1;
            }
        }

        for (int i = 0; i < quantity; i++) {
            targetLocation.getWorld().spawnEntity(targetLocation, EntityMonster);
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + quantity + " &cZombie on &b" + targetLocation + "&c."));
        return true;
    }
}