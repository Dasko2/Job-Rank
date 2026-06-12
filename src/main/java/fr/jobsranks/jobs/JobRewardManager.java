package fr.jobsranks.jobs;

import fr.jobsranks.Main;
import org.bukkit.entity.Player;

public class JobRewardManager {

    public void giveMoney(
            Player player,
            double amount
    ) {

        Main.getInstance()
                .getEconomy()
                .depositPlayer(
                        player,
                        amount
                );
    }
}
