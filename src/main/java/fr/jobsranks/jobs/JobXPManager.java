package fr.jobsranks.jobs;

import fr.jobsranks.data.PlayerData;

public class JobXPManager {

    private final JobLevelManager levelManager;

    public JobXPManager(
            JobLevelManager levelManager
    ) {
        this.levelManager = levelManager;
    }

    public boolean addXp(
            PlayerData data,
            JobType job,
            double amount
    ) {

        double xp =
                data.getXp(job) + amount;

        data.setXp(job, xp);

        boolean levelUp = false;

        while (
                xp >= levelManager.getRequiredXp(
                        data.getLevel(job)
                )
        ) {

            xp -= levelManager.getRequiredXp(
                    data.getLevel(job)
            );

            data.setLevel(
                    job,
                    data.getLevel(job) + 1
            );

            data.setXp(job, xp);

            levelUp = true;
        }

        return levelUp;
    }
}
