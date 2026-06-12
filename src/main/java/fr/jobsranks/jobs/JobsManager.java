package fr.jobsranks.jobs;

import fr.jobsranks.Main;
import org.bukkit.configuration.ConfigurationSection;

public class JobsManager {

    public double getXp(
            JobType job,
            String key
    ) {

        String path =
                "jobs."
                + job.name()
                .toLowerCase()
                + ".xp."
                + key;

        return Main.getInstance()
                .getConfig()
                .getDouble(path);
    }

    public double getMoney(
            JobType job,
            String key
    ) {

        String path =
                "jobs."
                + job.name()
                .toLowerCase()
                + ".money."
                + key;

        return Main.getInstance()
                .getConfig()
                .getDouble(path);
    }

    public boolean exists(
            JobType job,
            String key
    ) {

        String path =
                "jobs."
                + job.name()
                .toLowerCase()
                + ".xp."
                + key;

        return Main.getInstance()
                .getConfig()
                .contains(path);
    }
}
