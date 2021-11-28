package net.skylyfe.plugins.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;

import static org.bukkit.Bukkit.getLogger;

public class EventHandler {

    static boolean blockEvent = false;

    @org.bukkit.event.EventHandler(priority = EventPriority.MONITOR)
    public static void onBreakBlock(BlockBreakEvent event) {
        if (event.isCancelled()) {
            blockEvent = false;
            getLogger().info("Event Negative");
            return;
        }
        blockEvent = true;
        getLogger().info("Event Postitive");
    }
}
