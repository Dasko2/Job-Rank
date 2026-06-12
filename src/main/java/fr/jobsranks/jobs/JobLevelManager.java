package fr.jobsranks.jobs;

import fr.jobsranks.Main;

public class JobLevelManager {

    public double getRequiredXp(int level) {

        double first =
                Main.getInstance()
                        .getConfig()
                        .getDouble(
                                "jobs.leveling.first_level_xp"
                        );

        double multiplier =
                Main.getInstance()
                        .getConfig()
                        .getDouble(
                                "jobs.leveling.formula.multiplier"
                        );

        return first *
                Math.pow(
                        multiplier,
                        level - 1
                );
    }
}
