package me.lava.betterchat;

import co.aikar.commands.PaperCommandManager;
import me.lava.betterchat.cmds.BCCommand;
import me.lava.betterchat.events.*;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BetterChat extends JavaPlugin {
    public static BetterChat instance;
    public LuckPerms luckPerms;
    public static PaperCommandManager acf;
    public String format;
    public Boolean enabled;
    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        acf = new PaperCommandManager(this);
        acf.registerCommand(new BCCommand());
        format = BetterChat.instance.getConfig().getString("chatMessageFormat");
        enabled = BetterChat.instance.getConfig().getBoolean("betterChatEnabled");
        if (Bukkit.getPluginManager().isPluginEnabled("LuckPerms")) luckPerms = LuckPermsProvider.get();
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatEvent(), this);
    }
}