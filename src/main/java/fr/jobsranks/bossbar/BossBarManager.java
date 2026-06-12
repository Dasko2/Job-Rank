package fr.jobsranks.bossbar;

import fr.jobsranks.jobs.JobType;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BossBarManager {

    private final Map<UUID, BossBar> bars =
            new HashMap<>();

    public void show(
            Player player,
            String text,
            double progress
    ) {

        BossBar bar =
                bars.computeIfAbsent(
                        player.getUniqueId(),
                        id -> Bukkit.createBossBar(
                                "",
                                BarColor.BLUE,
                                BarStyle.SOLID
                        )
                );

        bar.setTitle(text);
        bar.setProgress(
                Math.max(
                        0,
                        Math.min(
                                1,
                                progress
                        )
                )
        );

        bar.addPlayer(player);
    }

    public void remove(
            Player player
    ) {

        BossBar bar =
                bars.remove(
                        player.getUniqueId()
                );

        if (bar != null) {
            bar.removeAll();
        }
    }
}
