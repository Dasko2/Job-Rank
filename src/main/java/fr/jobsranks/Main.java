package fr.jobsranks;

import fr.jobsranks.data.PlayerDataManager;
import fr.jobsranks.jobs.JobLevelManager;
import fr.jobsranks.jobs.JobXPManager;
import fr.jobsranks.jobs.JobsManager;
import fr.jobsranks.rank.RankManager;
import fr.jobsranks.rank.RankRequirementChecker;
import fr.jobsranks.utils.AntiSpamXPManager;
import fr.jobsranks.utils.BuilderCooldownManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private Economy economy;

    private PlayerDataManager playerDataManager;
    private JobLevelManager jobLevelManager;
    private JobXPManager jobXPManager;
    private JobsManager jobsManager;

    private RankManager rankManager;
    private RankRequirementChecker rankRequirementChecker;

    private AntiSpamXPManager antiSpamXPManager;
    private BuilderCooldownManager builderCooldownManager;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        setupEconomy();

        playerDataManager = new PlayerDataManager();

        jobLevelManager = new JobLevelManager();
        jobXPManager = new JobXPManager(jobLevelManager);
        jobsManager = new JobsManager();

        rankManager = new RankManager();
        rankRequirementChecker =
                new RankRequirementChecker();

        antiSpamXPManager =
                new AntiSpamXPManager();

        builderCooldownManager =
                new BuilderCooldownManager();

        getLogger().info("JobsRanks PRO ENABLED");
    }

    private void setupEconomy() {

        RegisteredServiceProvider<Economy> rsp =
                getServer()
                        .getServicesManager()
                        .getRegistration(Economy.class);

        if (rsp != null) {
            economy = rsp.getProvider();
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public Economy getEconomy() {
        return economy;
    }

    public PlayerDataManager getPlayerDataManager() {
        return playerDataManager;
    }

    public JobLevelManager getJobLevelManager() {
        return jobLevelManager;
    }

    public JobXPManager getJobXPManager() {
        return jobXPManager;
    }

    public JobsManager getJobsManager() {
        return jobsManager;
    }

    public RankManager getRankManager() {
        return rankManager;
    }

    public RankRequirementChecker getRankRequirementChecker() {
        return rankRequirementChecker;
    }

    public AntiSpamXPManager getAntiSpamXPManager() {
        return antiSpamXPManager;
    }

    public BuilderCooldownManager getBuilderCooldownManager() {
        return builderCooldownManager;
    }
}
