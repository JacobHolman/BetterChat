package me.lava.betterchat.events;

import me.lava.betterchat.BetterChat;
import net.luckperms.api.model.user.User;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AsyncPlayerChatEvent implements Listener {
    @EventHandler
    public void onPlayerChat(org.bukkit.event.player.AsyncPlayerChatEvent e) {
        if(!BetterChat.instance.enabled) return;
        User user = BetterChat.instance.luckPerms.getUserManager().getUser(e.getPlayer().getUniqueId());
        String coloredMsg = ChatColor.translateAlternateColorCodes('&', BetterChat.instance.format);
        String replacedWithPlayerMsg = coloredMsg.replace("%player%", e.getPlayer().getName());
        String formattedMsgOld = replacedWithPlayerMsg.replace("%msg%", e.getMessage());

        String prefix = user.getCachedData().getMetaData().getPrefix();
        String suffix = user.getCachedData().getMetaData().getSuffix();

        if (prefix == null || prefix.isEmpty()) {
            prefix = "";
        }

        if (suffix == null || suffix.isEmpty()) {
            suffix = "";
        }

        String formattedMsg = formattedMsgOld.replace("%prefix%", ChatColor.translateAlternateColorCodes('&', prefix));
        String formattedMsgNew = formattedMsg.replace("%suffix%", ChatColor.translateAlternateColorCodes('&', suffix));
        e.setFormat(formattedMsgNew);
    }
}