package fr.jobsranks.listeners;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import fr.jobsranks.data.PlayerDataStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener
        implements Listener {

    private final PlayerDataStorage storage;

    public PlayerJoinListener(
            PlayerDataStorage storage
    ) {
        this.storage = storage;
    }

    @EventHandler
    public void onJoin(
            PlayerJoinEvent event
    ) {

        PlayerData data =
                storage.load(
                        event.getPlayer()
                                .getUniqueId()
                );

        Main.getInstance()
                .getPlayerDataManager()
                .getCache()
                .put(
                        event.getPlayer()
                                .getUniqueId(),
                        data
                );
    }
}
