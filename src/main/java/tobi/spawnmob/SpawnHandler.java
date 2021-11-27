package tobi.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnHandler {

    /**
     * Takes the parametes and spawn a monster at some a location 'i' times
     * @param player
     * @param location
     * @param quantityMobs
     * @param monster
     */
    public static void spawnMonster(Player player,Location location, int quantityMobs, EntityType monster){
        for (int i = 0; i < quantityMobs; i++) {
            location.getWorld().spawnEntity(location, monster);
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + quantityMobs + " &cZombie on &b" + location + "&c."));
    }
}
