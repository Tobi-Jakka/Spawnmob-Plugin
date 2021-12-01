package net.skylyfe.plugins.spawnmob;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutoCompleter implements TabCompleter {

    private String[] commands = {"spawnmob"};
    private String[] mobtypes = {"sheep", "cow", "chicken", "cod", "ocelot", "pig", "snowman", "rabbit", "salmon", "mushroom_cow", "squid", "tropical_fish", "pufferfish",
                                 "turtle", "villager", "donkey", "horse", "parrot", "wolf", "dolphin", "polar_bear", "llama", "bee", "spider", "zombie", "creeper",
                                 "blaze", "skeleton", "guardian", "magma_cube", "slime", "enderman"};
    private String[] quantity = {"1", "2", "3", "4", "5", "6", "7", "8"};

    public List<String> onTabComplete (CommandSender sender, Command command, String alias, String[] args) {
        final List<String> completions = new ArrayList<String>();
        if (command.getName().equalsIgnoreCase("spawnmob")) {
            if (args.length == 1) {
                StringUtil.copyPartialMatches(args[0], Arrays.asList(mobtypes), completions);
            }
            if (args.length == 2) {
                StringUtil.copyPartialMatches(args[1], Arrays.asList(quantity), completions);
            }
            if (args.length == 3) {
                return null;
            }
        }
        return completions;
    }
}
