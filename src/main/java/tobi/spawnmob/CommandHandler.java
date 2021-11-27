package tobi.spawnmob;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Syntax: /spawnmob <entity>"));
                return true;
            }

            Location location = p.getLocation();
            if (args.length >= 3){
                Player targetPlayer = getServer().getPlayer(args[2]);
                location = targetPlayer.getLocation();
            }

            int quantityMobs = 1;
            if (args.length >= 2){
                quantityMobs = Integer.parseInt(args[1]);

                if(Integer.parseInt(args[1]) > 8){
                    quantityMobs = 8; //if the quantityOfMonsters is > 8 then just spawn 8. (Change to config later)
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
}

