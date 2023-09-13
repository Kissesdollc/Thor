package org.kissesdollc.thor.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ThorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("thor")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("all")) {
                        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                            onlinePlayer.getWorld().strikeLightning(onlinePlayer.getLocation());
                        }
                        sender.sendMessage("§aAll players were struck by lightning");
                    } else {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.getWorld().strikeLightning(target.getLocation());
                            sender.sendMessage("§aYou have launched a lightning bolt at §f" + target.getName() + "!");
                        } else {
                            sender.sendMessage("§cThe specified player is not online.");
                        }
                    }
                } else {
                    sender.sendMessage("§cusage: /thor <jugador/all>");
                }
            } else {
                sender.sendMessage("This command can only be executed by one player in the game.");
            }
            return true;
        }
        return false;
    }
}
