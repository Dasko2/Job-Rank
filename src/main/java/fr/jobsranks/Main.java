package fr.jobsranks;

import fr.jobsranks.bossbar.BossBarManager;
import fr.jobsranks.data.PlayerDataManager;
import fr.jobsranks.data.PlayerDataStorage;
import fr.jobsranks.jobs.JobLevelManager;
import fr.jobsranks.jobs.JobRewardManager;
import fr.jobsranks.jobs.JobXPManager;
import fr.jobsranks.jobs.JobsManager;
import fr.jobsranks.jobs.NaturalBlockManager;
import fr.jobsranks.listeners.BlockBreakListener;
import fr.jobsranks.listeners.BlockPlaceListener;
import fr.jobsranks.listeners.BuilderListener;
import fr.jobsranks.listeners.PlayerJoinListener;
import fr.jobsranks.listeners.PlayerQuitListener;
import fr.jobsranks.rank.RankManager;
import fr.jobsranks.rank.RankRequirementChecker;
import fr.jobsranks.tasks.PlaytimeTask;
import fr.jobsranks.utils.AntiSpamXPManager;
import fr.jobsranks.utils.BuilderCooldownManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private Economy economy;

    private PlayerDataManager playerDataManager;
    private PlayerDataStorage playerDataStorage;

    private JobLevelManager jobLevelManager;
    private JobXPManager jobXPManager;
    private JobsManager jobsManager;
    private JobRewardManager jobRewardManager;

    private RankManager rankManager;
    private RankRequirementChecker rankRequirementChecker;

    private AntiSpamXPManager antiSpamXPManager;
    private BuilderCooldownManager builderCooldownManager;

    private NaturalBlockManager naturalBlockManager;

    private BossBarManager bossBarManager;

    @Override
    public void onEnable() {

        instance = this;

        saveDefaultConfig();

        setupEconomy();

        playerDataManager = new PlayerDataManager();
        playerDataStorage = new PlayerDataStorage(this);

        jobLevelManager = new JobLevelManager();
        jobXPManager = new JobXPManager(jobLevelManager);
        jobsManager = new JobsManager();
        jobRewardManager = new JobRewardManager();

        rankManager = new RankManager();
        rankRequirementChecker = new RankRequirementChecker();

        antiSpamXPManager = new AntiSpamXPManager();
        builderCooldownManager = new BuilderCooldownManager();

        naturalBlockManager = new NaturalBlockManager();

        bossBarManager = new BossBarManager();

        getServer().getPluginManager().registerEvents(
                new PlayerJoinListener(playerDataStorage),
                this
        );

        getServer().getPluginManager().registerEvents(
                new PlayerQuitListener(playerDataStorage),
                this
        );

        getServer().getPluginManager().registerEvents(
                new BlockPlaceListener(naturalBlockManager),
                this
        );

        getServer().getPluginManager().registerEvents(
                new BuilderListener(),
                this
        );

        getServer().getPluginManager().registerEvents(
                new BlockBreakListener(naturalBlockManager),
                this
        );

        new PlaytimeTask().runTaskTimer(
                this,
                1200L,
                1200L
        );

        getLogger().info("JobsRanks PRO ENABLED");
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

    public PlayerDataStorage getPlayerDataStorage() {
        return playerDataStorage;
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

    public JobRewardManager getJobRewardManager() {
        return jobRewardManager;
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

    public NaturalBlockManager getNaturalBlockManager() {
        return naturalBlockManager;
    }

    public BossBarManager getBossBarManager() {
        return bossBarManager;
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
}
