package fr.jobsranks.listeners;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;
import fr.jobsranks.data.PlayerDataStorage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerQuitListener
        implements Listener {

    private final PlayerDataStorage storage;

    public PlayerQuitListener(
            PlayerDataStorage storage
    ) {
        this.storage = storage;
    }

    @EventHandler
    public void onQuit(
            PlayerQuitEvent event
    ) {

        UUID uuid =
                event.getPlayer()
                        .getUniqueId();

        PlayerData data =
                Main.getInstance()
                        .getPlayerDataManager()
                        .get(uuid);

        storage.save(data);

        Main.getInstance()
                .getPlayerDataManager()
                .remove(uuid);
    }
}
