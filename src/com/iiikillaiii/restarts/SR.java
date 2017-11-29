package com.iiikillaiii.restarts;

import org.bukkit.plugin.java.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.scheduler.*;
import org.bukkit.command.*;

public class SR extends JavaPlugin implements Listener
{
    public static int repeater;
    public static boolean repeaterb;
    public static Plugin instance;
    public static String prefix;
    public static int countdown;
    
    static {
        SR.repeater = 0;
        SR.repeaterb = false;
        SR.prefix = "§7(§c§lMaple§f§lCraft§7) ";
        SR.countdown = 0;
    }
    
    public void onEnable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§7(§c§lMaple§f§lCraft§7)§7 has been enabled correctly!");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        SR.instance = (Plugin)this;
        ActionAPI.nmsver = Bukkit.getServer().getClass().getPackage().getName();
        ActionAPI.nmsver = ActionAPI.nmsver.substring(ActionAPI.nmsver.lastIndexOf(".") + 1);
        Bukkit.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        startCountdown();
    }
    
    public static void sendMessage(final Player p) {
        if (StartRestart.timeUntilStart2 < 60) {
            p.sendMessage(String.valueOf(SR.prefix) + SR.instance.getConfig().getString("NormalMessages.message").replace("&", "§").replace("{time}", StartRestart.counter + " secs"));
        }
        if (StartRestart.timeUntilStart2 >= 60) {
            p.sendMessage(String.valueOf(SR.prefix) + SR.instance.getConfig().getString("NormalMessages.message").replace("&", "§").replace("{time}", StartRestart.counter + " min"));
        }
    }
    
    public static void broadcastActionBar(final Player p) {
        SR.repeater = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(SR.instance, (Runnable)new Runnable() {
            @Override
            public void run() {
                if (StartRestart.timeUntilStart2 < 60) {
                    ActionAPI.sendActionBar(p, SR.instance.getConfig().getString("ActionBar.message").replace("&", "§").replace("{multicolor}", SR.getMulticolor()).replace("{time}", StartRestart.counter + " secs"));
                }
                if (StartRestart.timeUntilStart2 >= 60) {
                    ActionAPI.sendActionBar(p, SR.instance.getConfig().getString("ActionBar.message").replace("&", "§").replace("{multicolor}", SR.getMulticolor()).replace("{time}", StartRestart.counter + " min"));
                }
            }
        }, 0L, 5L);
        if (!SR.repeaterb) {
            SR.repeaterb = true;
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SR.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().cancelTask(SR.repeater);
                    SR.repeaterb = false;
                }
            }, 200L);
        }
    }
    
    public static String getMulticolor() {
        String s = null;
        final Random localRandom = new Random();
        for (int j = 1; j <= 1; ++j) {
            j = 1 + localRandom.nextInt(6);
            if (j == 1) {
                s = "§a§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 2) {
                s = "§e§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 3) {
                s = "§b§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 4) {
                s = "§c§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 5) {
                s = "§1§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 6) {
                s = "§5§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 7) {
                s = "§d§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
            if (j == 8) {
                s = "§6§l" + SR.instance.getConfig().getString("ActionBar.multicolorPrefix");
            }
        }
        return s;
    }
    
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§7(§c§lMaple§f§lCraft§7)§7 has been disabled correctly!");
    }
    
    public static void startCountdown() {
        final int CdTime = StartRestart.timeUntilStart2 = 1 + 60 * SR.instance.getConfig().getInt("TimeInMinutesReset");
        SR.countdown = SR.instance.getServer().getScheduler().scheduleSyncRepeatingTask(SR.instance, (BukkitRunnable)new StartRestart(null), 20L, 20L);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("serverrestart")) {
            if (args.length == 0) {
                sender.sendMessage(" ");
                sender.sendMessage("§7(§c§lMaple§f§lRestarts§7)");
                sender.sendMessage("§e/mr forcestart §7- §eForce to restart the server in 3 minutes");
                return true;
            }
            if (args[0].equalsIgnoreCase("check") && p.hasPermission("maple.restart.check")) {
                p.sendMessage(String.valueOf(SR.prefix) + SR.instance.getConfig().getString("NormalMessages.oncommand").replace("&", "§").replace("{time}", StartRestart.counter));
            }
            if (args[0].equalsIgnoreCase("forcestart") && p.hasPermission("maple.restart.check")) {
                Bukkit.getServer().getScheduler().cancelTask(SR.countdown);
                p.sendMessage(String.valueOf(SR.prefix) + SR.instance.getConfig().getString("NormalMessages.oncommandforce").replace("&", "§"));
                final int CdTime = StartRestart.timeUntilStart2 = 180;
                SR.countdown = SR.instance.getServer().getScheduler().scheduleSyncRepeatingTask(SR.instance, (BukkitRunnable)new StartRestart(null), 20L, 20L);
            }
        }
        return true;
    }
    
    public static Plugin instance() {
        return SR.instance;
    }
    
    public static void CombatRefresh() {
        Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "plugman reload CombatTagPlus");
    }
}
