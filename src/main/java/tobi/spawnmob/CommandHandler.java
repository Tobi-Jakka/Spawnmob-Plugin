package tobi.spawnmob;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import static java.lang.Integer.parseInt;
import static org.bukkit.Bukkit.getServer;

public class CommandHandler implements CommandExecutor {

    public static boolean isNumeric(String string) {
        int intValue;

        System.out.println(String.format("Parsing string: \"%s\"", string));

        if(string == null || string.equals("")) {
            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }


    //public SpawnMob() {}
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length <= 1) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Syntax: /spawnmob <entity>"));
                return true;
            }

            Location location = p.getLocation();
            if (args.length == 3){
                Player targetPlayer = getServer().getPlayer(args[2]);
                location = targetPlayer.getLocation();
            }

            int quantityMobs = 1;
            if (args.length == 2){
                if(Integer.parseInt(args[2]) > 8){
                    quantityMobs = 8; //if the the quantityOfMonsters is > 8 then just spawn 8. (Change to config later)
                }
            }



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



    /* public boolean onCommand1(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player)
        {
            Player p = (Player) sender;
            Location loc = p.getLocation();

            System.out.println("Args length:" + args.length);
            if(args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Syntax: /spawnmob <entity>"));
                //return false;
            }
            else {
                switch(args[0].toUpperCase()) {
                    case "ZOMBIE":
                        if (args.length == 1) {
                            loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b1 &cZombie."));
                            
                        }
                        else if (args.length == 2) {
                            if (!isNumeric(args[1])) return false;
                            for(int i = 0; i  < parseInt(args[1]); i++) {
                                loc.getWorld().spawnEntity(loc,EntityType.ZOMBIE);
                            }
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + args[1] + " &cZombie."));
                        }
                        else if (args.length == 3) {
                            Player t = getServer().getPlayer(args[2]);
                            Location tloc = t.getLocation();

                            for (int i = 0; i < parseInt(args[1]); i++) {
                                tloc.getWorld().spawnEntity(tloc, EntityType.ZOMBIE);
                            }
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSpawned &b" + args[1] + " &cZombie on &b" + args[2] + "&c."));
                        }
                        break;

                    case "SKELETON":
                        for(int i = 0; i  < parseInt(args[1]); i++) {
                            loc.getWorld().spawnEntity(loc,EntityType.SKELETON);
                            System.out.println("Skeleton Spawned");
                        }
                        break;
                    }
                }
                return true;
            }
        return false;
        } */
    }

