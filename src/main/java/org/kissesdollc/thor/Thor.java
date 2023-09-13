package org.kissesdollc.thor;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.kissesdollc.thor.command.ThorCommand;

public final class Thor extends JavaPlugin {

    CommandSender console = Bukkit.getConsoleSender();
    public String version = getDescription().getVersion();
    public String author = getDescription().getAuthors().toString();

    @Override
    public void onEnable() {
        console.sendMessage("------------------------");
        console.sendMessage("§3Thor §7version §f"+version);
        console.sendMessage("§3Author &f"+author);
        console.sendMessage("------------------------");
        getCommand("thor").setExecutor(new ThorCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
