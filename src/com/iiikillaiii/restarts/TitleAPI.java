package com.iiikillaiii.restarts;

import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.spigotmc.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;

public class TitleAPI implements Listener
{
    public TitleAPI(final SR plugin) {
        plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    public static boolean sendTitle(final Player p, final int time, final int fadein, final int fadeout, String sub, String title) {
        title = ChatColor.translateAlternateColorCodes('&', title);
        sub = ChatColor.translateAlternateColorCodes('&', sub);
        try {
            final ProtocolInjector.PacketTitle length = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TIMES, fadein, time, fadeout);
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)length);
            final IChatBaseComponent chatTitle = ChatSerializer.a("{\"text\": \"\"}").a(title);
            final ProtocolInjector.PacketTitle title2 = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, chatTitle);
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)title2);
            final IChatBaseComponent chatsubTitle = ChatSerializer.a("{\"text\": \"\"}").a(sub);
            final ProtocolInjector.PacketTitle title3 = new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, chatsubTitle);
            ((CraftPlayer)p).getHandle().playerConnection.sendPacket((Packet)title3);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
