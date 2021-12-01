package net.skylyfe.plugins.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class CooldownHandler {

    static Map<String, Long> cooldowns = new HashMap<String, Long>();

    public static boolean CooldownChecker(Player player) {


            if (cooldowns.containsKey(player.getName())) {
                if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {

                    long timeleft = (cooldowns.get(player.getName()) - System.currentTimeMillis()) / 1000;

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&cYou can't spawn mobs before in &b" + timeleft + " &cseconds"));
                    return false;
                }
            }
            cooldowns.put(player.getName(), System.currentTimeMillis() + (15 * 1000));

    return true;
    }
}
