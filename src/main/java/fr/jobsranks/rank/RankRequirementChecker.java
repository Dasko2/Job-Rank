package fr.jobsranks.rank;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import org.bukkit.entity.Player;

public class RankRequirementChecker {

    public boolean hasMoney(
            Player player,
            int nextRank
    ) {

        double required =
                Main.getInstance()
                        .getConfig()
                        .getDouble(
                                "ranks.list."
                                + nextRank
                                + ".money_required"
                        );

        return Main.getInstance()
                .getEconomy()
                .getBalance(player)
                >= required;
    }

    public boolean hasPlaytime(
            PlayerData data,
            int nextRank
    ) {

        long required =
                Main.getInstance()
                        .getConfig()
                        .getLong(
                                "ranks.list."
                                + nextRank
                                + ".playtime_required_hours"
                        );

        return data.getPlaytimeSeconds()
                >= required * 3600;
    }

    public boolean hasJobLevels(
            PlayerData data,
            int nextRank
    ) {

        int required =
                Main.getInstance()
                        .getConfig()
                        .getInt(
                                "ranks.list."
                                + nextRank
                                + ".total_jobs_required"
                        );

        return data.getTotalLevels()
                >= required;
    }
}
