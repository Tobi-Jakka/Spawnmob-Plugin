package net.skylyfe.plugins.spawnmob;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class SpawnHandler {

    public static boolean allowedTypes(String input) {
        switch(input.toUpperCase()) {
            case "ZOMBIE":
            case "SKELETON":
            case "SPIDER":
            case "CREEPER":
            case "BLAZE":
            case "GUARDIAN":
            case "MAGMA_CUBE":
            case "SLIME":
            case "ENDERMAN":
            case "SHEEP":
            case "COW":
            case "CHICKEN":
            case "COD":
            case "OCELOT":
            case "PIG":
            case "SNOWMAN":
            case "RABBIT":
            case "SALMON":
            case "MUSHROOM_COW":
            case "SQUID":
            case "TROPICAL_FISH":
            case "PUFFERFISH":
            case "TURTLE":
            case "VILLAGER":
            case "DONKEY":
            case "HORSE":
            case "PARROT":
            case "WOLF":
            case "DOLPHIN":
            case "POLAR_BEAR":
            case "LLAMA":
            case "BEE":
                return true;

            default:
                return false;
        }
    }

    public static boolean typeTester(String input) {
        try {
        EntityType EntityMonster = EntityType.valueOf(input.toUpperCase());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean amountTester(String input) {
        try {
            int quantity = Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean locationTester(String input) {
        try {
            Location targetLocation = getServer().getPlayer(input).getLocation();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean spawnMonster(Player player, String[] args){
        if (args.length < 1) return true;

        String monster = args[0];
        int quantity = 1;

        if (!typeTester(monster)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&cInvalid type"));
            return true;
        }
        EntityType EntityMonster = EntityType.valueOf(monster.toUpperCase());

        if (!allowedTypes(monster)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',  "&cYou are not allowed to spawn that type!"));
            return true;
        }

        if (args.length >= 2) {
            if (!amountTester(args[1])) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cInvalid amount"));
                return true;
            }
            quantity = Integer.parseInt(args[1]);

            if (quantity < 1 || quantity > 4) {
                quantity = 1;
            }
        }

        Location targetLocation = player.getLocation();

        if (args.length >= 3) {
            if (!locationTester(args[2])) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cInvalid player"));
                return true;
            }
            targetLocation = getServer().getPlayer(args[2]).getLocation();
        }

        if (!CooldownHandler.CooldownChecker(player)) {
            return true; //msg handled in CooldownHandler
        }

        for (int i = 0; i < quantity; i++) {
            targetLocation.getWorld().spawnEntity(targetLocation, EntityMonster);
        }
        if(args.length <= 2) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + quantity + " &c" + monster));
            return true;
        }
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + quantity + " &b" + monster + " &con &b" + args[2]));
            return true;
    }
}