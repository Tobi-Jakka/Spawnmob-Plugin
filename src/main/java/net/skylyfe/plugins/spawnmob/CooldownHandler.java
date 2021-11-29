package net.skylyfe.plugins.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CooldownHandler {
    public static boolean CooldownChecker(Player player) {
        HashMap<Player, Long> cooldown = new HashMap<>();
            cooldown.put(player, (System.currentTimeMillis() / 1000));
            long cooldownTimeLeft = (cooldown.get(player) + 15) - (System.currentTimeMillis() / 1000);
            if((cooldown.get(player) + 15) >= (System.currentTimeMillis() / 1000)){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&cYou can't spawn mobs before in &b" + cooldownTimeLeft + " &cseconds"));
            return false;
        }
        return true;
    }
}
