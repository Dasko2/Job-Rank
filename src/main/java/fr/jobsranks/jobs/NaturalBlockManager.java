package fr.jobsranks.jobs;

import org.bukkit.Location;

import java.util.HashSet;
import java.util.Set;

public class NaturalBlockManager {

    private final Set<String> placedBlocks =
            new HashSet<>();

    private String serialize(
            Location location
    ) {

        return location.getWorld().getName()
                + ";"
                + location.getBlockX()
                + ";"
                + location.getBlockY()
                + ";"
                + location.getBlockZ();
    }

    public void markPlaced(
            Location location
    ) {

        placedBlocks.add(
                serialize(location)
        );
    }

    public boolean isNatural(
            Location location
    ) {

        return !placedBlocks.contains(
                serialize(location)
        );
    }

    public void remove(
            Location location
    ) {

        placedBlocks.remove(
                serialize(location)
        );
    }
}
