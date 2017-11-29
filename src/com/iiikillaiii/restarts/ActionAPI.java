package com.iiikillaiii.restarts;

import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;

public class ActionAPI
{
    public static boolean works;
    public static String nmsver;
    
    static {
        ActionAPI.works = true;
    }
    
    public static void sendActionBar(final Player player, final String message) {
        final CraftPlayer p = (CraftPlayer)player;
        if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
            return;
        }
        final IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + message + "\"}");
        final PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, 2);
        p.getHandle().playerConnection.sendPacket((Packet)ppoc);
    }
}
