package fr.jobsranks.listeners;

import fr.jobsranks.jobs.NaturalBlockManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener
        implements Listener {

    private final NaturalBlockManager manager;

    public BlockPlaceListener(
            NaturalBlockManager manager
    ) {
        this.manager = manager;
    }

    @EventHandler
    public void onPlace(
            BlockPlaceEvent event
    ) {

        manager.markPlaced(
                event.getBlock()
                        .getLocation()
        );
    }
}
