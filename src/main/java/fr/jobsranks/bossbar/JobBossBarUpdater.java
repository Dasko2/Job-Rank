package fr.jobsranks.bossbar;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import fr.jobsranks.jobs.JobType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class JobBossBarUpdater
        extends BukkitRunnable {

    @Override
    public void run() {

        for (Player player :
                Bukkit.getOnlinePlayers()) {

            PlayerData data =
                    Main.getInstance()
                            .getPlayerDataManager()
                            .get(
                                    player.getUniqueId()
                            );

            JobType job =
                    JobType.MINEUR;

            double current =
                    data.getXp(job);

            double required =
                    Main.getInstance()
                            .getJobLevelManager()
                            .getRequiredXp(
                                    data.getLevel(job)
                            );

            Main.getInstance()
                    .getBossBarManager()
                    .show(
                            player,
                            "§b"
                                    + job.name()
                                    + " §7| §eLvl "
                                    + data.getLevel(job),
                            current / required
                    );
        }
    }
}
