package fr.jobsranks.data;

import fr.jobsranks.Main;
import fr.jobsranks.jobs.JobType;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerDataStorage {

    private final Main plugin;

    public PlayerDataStorage(Main plugin) {
        this.plugin = plugin;
    }

    public void save(PlayerData data) {

        File folder = new File(
                plugin.getDataFolder(),
                "players"
        );

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(
                folder,
                data.getUuid().toString() + ".yml"
        );

        YamlConfiguration config =
                new YamlConfiguration();

        config.set("rank", data.getRank());
        config.set(
                "playtime",
                data.getPlaytimeSeconds()
        );

        for (JobType job : JobType.values()) {

            config.set(
                    "jobs."
                            + job.name()
                            + ".level",
                    data.getLevel(job)
            );

            config.set(
                    "jobs."
                            + job.name()
                            + ".xp",
                    data.getXp(job)
            );
        }

        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PlayerData load(UUID uuid) {

        File file = new File(
                plugin.getDataFolder()
                        + "/players",
                uuid + ".yml"
        );

        PlayerData data =
                new PlayerData(uuid);

        if (!file.exists()) {
            return data;
        }

        YamlConfiguration config =
                YamlConfiguration.loadConfiguration(
                        file
                );

        data.setRank(
                config.getInt("rank", 1)
        );

        data.setPlaytimeSeconds(
                config.getLong(
                        "playtime",
                        0
                )
        );

        for (JobType job : JobType.values()) {

            data.setLevel(
                    job,
                    config.getInt(
                            "jobs."
                                    + job.name()
                                    + ".level",
                            1
                    )
            );

            data.setXp(
                    job,
                    config.getDouble(
                            "jobs."
                                    + job.name()
                                    + ".xp",
                            0
                    )
            );
        }

        return data;
    }
}
