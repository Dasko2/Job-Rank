package fr.jobsranks.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BuilderCooldownManager {

    private final Map<UUID, Long> builderTime =
            new HashMap<>();

    public void placeBlock(
            UUID uuid
    ) {

        builderTime.put(
                uuid,
                System.currentTimeMillis()
        );
    }

    public boolean canGiveXp(
            UUID uuid
    ) {

        if (!builderTime.containsKey(uuid)) {
            return false;
        }

        long diff =
                System.currentTimeMillis()
                - builderTime.get(uuid);

        return diff >= 3000;
    }
}
