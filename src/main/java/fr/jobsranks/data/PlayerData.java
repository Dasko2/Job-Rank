package fr.jobsranks.data;

import fr.jobsranks.jobs.JobType;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {

    private final UUID uuid;

    private int rank;

    private long playtimeSeconds;

    private final Map<JobType, Integer> levels;
    private final Map<JobType, Double> xp;

    public PlayerData(UUID uuid) {

        this.uuid = uuid;

        this.rank = 1;

        this.playtimeSeconds = 0;

        this.levels = new EnumMap<>(JobType.class);
        this.xp = new EnumMap<>(JobType.class);

        for (JobType job : JobType.values()) {

            levels.put(job, 1);
            xp.put(job, 0.0);
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public long getPlaytimeSeconds() {
        return playtimeSeconds;
    }

    public void setPlaytimeSeconds(long playtimeSeconds) {
        this.playtimeSeconds = playtimeSeconds;
    }

    public int getLevel(JobType job) {
        return levels.get(job);
    }

    public void setLevel(JobType job, int level) {
        levels.put(job, level);
    }

    public double getXp(JobType job) {
        return xp.get(job);
    }

    public void setXp(JobType job, double amount) {
        xp.put(job, amount);
    }

    public int getTotalLevels() {

        int total = 0;

        for (Integer level : levels.values()) {
            total += level;
        }

        return total;
    }
}
