package fr.jobsranks.listeners;

import fr.jobsranks.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuilderListener
        implements Listener {

    @EventHandler
    public void onPlace(
            BlockPlaceEvent event
    ) {

        Main.getInstance()
                .getBuilderCooldownManager()
                .placeBlock(
                        event.getPlayer()
                                .getUniqueId()
                );
    }
}
