package fr.jobsranks.listeners;

import fr.jobsranks.Main;
import fr.jobsranks.jobs.NaturalBlockManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener
        implements Listener {

    private final NaturalBlockManager naturalManager;

    public BlockBreakListener(
            NaturalBlockManager naturalManager
    ) {
        this.naturalManager = naturalManager;
    }

    @EventHandler
    public void onBreak(
            BlockBreakEvent event
    ) {

        if (!naturalManager.isNatural(
                event.getBlock()
                        .getLocation()
        )) {

            return;
        }

        if (!Main.getInstance()
                .getBuilderCooldownManager()
                .canGiveXp(
                        event.getPlayer()
                                .getUniqueId()
                )) {

            return;
        }

        /*
         XP Mineur
         XP Builder
         sera branché ici
        */
    }
}
