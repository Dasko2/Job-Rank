package fr.jobsranks.tasks;

import fr.jobsranks.Main;
import fr.jobsranks.data.PlayerData;

public class AutoSaveTask
        implements Runnable {

    @Override
    public void run() {

        for (PlayerData data :
                Main.getInstance()
                        .getPlayerDataManager()
                        .getCache()
                        .values()) {

            Main.getInstance()
                    .getPlayerDataStorage()
                    .save(data);
        }
    }
}
