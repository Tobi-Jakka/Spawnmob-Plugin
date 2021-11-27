package net.skylyfe.spawnmob.spawnmob;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        
        // Register our command "kit" (set an instance of your command class as executor)
        this.getCommand("spawnmob").setExecutor(new CommandHandler());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
