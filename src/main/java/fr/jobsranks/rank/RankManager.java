package fr.jobsranks.rank;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import org.bukkit.configuration.ConfigurationSection;

public class RankManager {

    public int getMaxRank() {

        return Main.getInstance()
                .getConfig()
                .getInt("ranks.max");
    }

    public String getRankName(int rank) {

        return Main.getInstance()
                .getConfig()
                .getString(
                        "ranks.list."
                        + rank
                        + ".name"
                );
    }

    public int getHomes(int rank) {

        return Main.getInstance()
                .getConfig()
                .getInt(
                        "ranks.list."
                        + rank
                        + ".homes"
                );
    }

    public int getAhSlots(int rank) {

        return Main.getInstance()
                .getConfig()
                .getInt(
                        "ranks.list."
                        + rank
                        + ".ah_slots"
                );
    }

    public boolean canRankUp(
            PlayerData data
    ) {

        return data.getRank()
                < getMaxRank();
    }
}
