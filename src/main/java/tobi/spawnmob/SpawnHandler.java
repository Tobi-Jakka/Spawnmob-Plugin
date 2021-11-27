package tobi.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static java.lang.Integer.parseInt;
import static org.bukkit.Bukkit.getServer;

public class SpawnHandler {




    public static void spawnMonster(Player player,Location location, int quantityMobs, EntityType monster){

        for (int i = 0; i < quantityMobs; i++) {
            location.getWorld().spawnEntity(location, monster);
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + quantityMobs + " &cZombie on &b" + location + "&c."));

    }
//loc.getWorld().spawnEntity(loc,EntityType.ZOMBIE);


}
