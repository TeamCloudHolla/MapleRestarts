package com.iiikillaiii.restarts;

import org.bukkit.scheduler.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class StartRestart extends BukkitRunnable
{
    SR plugin;
    public static String counter;
    public static int timeUntilStart2;
    
    static {
        StartRestart.counter = null;
    }
    
    public StartRestart(final SR pl) {
        this.plugin = pl;
    }
    
    public void run() {
        if (StartRestart.timeUntilStart2 < 999999) {
            String timer = null;
            final int x = StartRestart.timeUntilStart2 / 60;
            final int time = StartRestart.timeUntilStart2 - x * 60;
            Math.round(StartRestart.timeUntilStart2);
            if (time < 10) {
                timer = String.valueOf(x) + ":" + 0 + time;
            }
            else {
                timer = String.valueOf(x) + ":" + time;
            }
            StartRestart.counter = timer;
        }
        if (StartRestart.timeUntilStart2 == 300) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 240) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 180) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 120) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 60) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 30) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 20) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 10) {
            Player[] arrayOfPlayer;
            for (int time = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, x = 0; x < time; ++x) {
                final Player p = arrayOfPlayer[x];
                SR.broadcastActionBar(p);
                SR.sendMessage(p);
            }
        }
        if (StartRestart.timeUntilStart2 == 5) {
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "plugman disable CombatTagPlus");
        }
        if (StartRestart.timeUntilStart2 <= 1) {
            Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "stop");
        }
        --StartRestart.timeUntilStart2;
    }
}
