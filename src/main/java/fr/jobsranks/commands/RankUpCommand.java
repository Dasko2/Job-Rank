package fr.jobsranks.commands;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankUpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {

        if (!(sender instanceof Player player))
            return true;

        PlayerData data =
                Main.getInstance()
                        .getPlayerDataManager()
                        .get(player.getUniqueId());

        int nextRank =
                data.getRank() + 1;

        if (!Main.getInstance()
                .getRankManager()
                .canRankUp(data)) {

            player.sendMessage(
                    "§cRank maximum atteint."
            );

            return true;
        }

        if (!Main.getInstance()
                .getRankRequirementChecker()
                .hasMoney(player, nextRank)) {

            player.sendMessage(
                    "§cArgent insuffisant."
            );

            return true;
        }

        if (!Main.getInstance()
                .getRankRequirementChecker()
                .hasPlaytime(data, nextRank)) {

            player.sendMessage(
                    "§cTemps de jeu insuffisant."
            );

            return true;
        }

        if (!Main.getInstance()
                .getRankRequirementChecker()
                .hasJobLevels(data, nextRank)) {

            player.sendMessage(
                    "§cNiveaux métiers insuffisants."
            );

            return true;
        }

        data.setRank(nextRank);

        player.sendMessage(
                "§aTu es maintenant rank "
                        + nextRank
        );

        return true;
    }
}
