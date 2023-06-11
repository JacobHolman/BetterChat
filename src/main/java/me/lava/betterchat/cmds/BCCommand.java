package me.lava.betterchat.cmds;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import me.lava.betterchat.BetterChat;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@CommandAlias("bc")
@CommandPermission("bc.admin")
public class BCCommand extends BaseCommand {
    @Subcommand("reload")
    public void reload(Player player){
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[BC] " + ChatColor.GRAY + "BetterChat was reloaded");
        BetterChat.instance.reloadConfig();
        BetterChat.instance.format = BetterChat.instance.getConfig().getString("chatMessageFormat");
        BetterChat.instance.enabled = BetterChat.instance.getConfig().getBoolean("betterChatEnabled");
    }

    @Subcommand("on")
    public void on(Player player){
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[BC] " + ChatColor.GRAY + "BetterChat was turned on");
        BetterChat.instance.getConfig().set("betterChatEnabled", true);
        BetterChat.instance.reloadConfig();
        BetterChat.instance.enabled = BetterChat.instance.getConfig().getBoolean("betterChatEnabled");
    }

    @Subcommand("off")
    public void off(Player player){
        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[BC] " + ChatColor.GRAY + "BetterChat was turned off");
        BetterChat.instance.getConfig().set("betterChatEnabled", false);
        BetterChat.instance.reloadConfig();
        BetterChat.instance.enabled = BetterChat.instance.getConfig().getBoolean("betterChatEnabled");
    }
}
