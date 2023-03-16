package ua.juniffiro.ms.boomfixer;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import ua.juniffiro.ms.boomfixer.cfg.CfgKey;
import ua.juniffiro.ms.boomfixer.commands.CommandReloadConfig;
import ua.juniffiro.ms.boomfixer.listener.MainListener;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 24/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        setupConfig();

        getCommand("bfreload").setExecutor(new CommandReloadConfig());

        registerListeners();
    }

    public boolean isPluginEnabled() {
        return getConfig().getBoolean(CfgKey.PLUGIN_ENABLED.path(), true);
    }

    private void registerListeners() {
        if (isPluginEnabled()) {
            getServer().getPluginManager().registerEvents(new MainListener(this), this);
        }
    }

    public void reload() {
        reloadConfig();
        HandlerList.unregisterAll(this);
        registerListeners();
    }

    private void setupConfig() {
        FileConfiguration config = this.getConfig();
        config.options().copyDefaults(true);
        this.saveConfig();
    }

    public boolean isActive(String key) {
        return getConfig().getBoolean(key, false);
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }
}
