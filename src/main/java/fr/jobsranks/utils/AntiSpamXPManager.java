package fr.jobsranks.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AntiSpamXPManager {

    private final Map<UUID, Long> lastXp =
            new HashMap<>();

    public boolean canReceiveXp(
            UUID uuid
    ) {

        long now =
                System.currentTimeMillis();

        if (!lastXp.containsKey(uuid)) {

            lastXp.put(uuid, now);

            return true;
        }

        long diff =
                now - lastXp.get(uuid);

        if (diff < 250) {
            return false;
        }

        lastXp.put(uuid, now);

        return true;
    }
}
