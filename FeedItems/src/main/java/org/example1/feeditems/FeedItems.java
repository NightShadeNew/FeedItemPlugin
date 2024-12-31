package org.example1.feeditems;

import org.bukkit.plugin.java.JavaPlugin;
import org.example1.sea.listener;
import sea.item;

public final class FeedItems extends JavaPlugin {
    public static FeedItems plugin;

    public static FeedItems getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new listener(), this);
        getCommand("feeditems").setExecutor(new item());

    }
}
