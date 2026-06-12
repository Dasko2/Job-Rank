package fr.jobsranks.economy;

import fr.jobsranks.Main;
import org.bukkit.entity.Player;

public class EconomyManager {

    public double getBalance(Player player) {

        return Main.getInstance()
                .getEconomy()
                .getBalance(player);
    }

    public void deposit(
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

    public boolean withdraw(
            Player player,
            double amount
    ) {

        if (getBalance(player) < amount) {
            return false;
        }

        Main.getInstance()
                .getEconomy()
                .withdrawPlayer(
                        player,
                        amount
                );

        return true;
    }
}
