package net.skylyfe.plugins.spawnmob;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    CommandHandler commandHandler = new CommandHandler();
    AutoCompleter autoComplete = new AutoCompleter();

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Load commands
        for (String command : commandHandler.cmds)
        {
            getCommand(command).setExecutor(commandHandler);
            getCommand(command).setTabCompleter(autoComplete);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
