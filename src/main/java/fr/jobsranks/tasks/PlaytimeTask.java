package fr.jobsranks.tasks;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlaytimeTask
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

            data.setPlaytimeSeconds(
                    data.getPlaytimeSeconds()
                            + 60
            );
        }
    }
}
