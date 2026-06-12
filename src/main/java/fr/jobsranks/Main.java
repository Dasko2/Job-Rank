package fr.jobsranks;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private Economy economy;

    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();

        setupEconomy();

        getLogger().info("JobsRanks PRO ENABLED");
    }

    private void setupEconomy() {

        RegisteredServiceProvider<Economy> rsp =
                getServer().getServicesManager().getRegistration(Economy.class);

        if (rsp != null) economy = rsp.getProvider();
    }

    public Economy getEconomy() {
        return economy;
    }

    public static Main getInstance() {
        return instance;
    }
}
