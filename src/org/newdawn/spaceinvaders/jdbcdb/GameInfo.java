package org.newdawn.spaceinvaders.jdbcdb;

public class GameInfo {

    private static int playTime = 0;
    private static int stage = 0;
    private static int killCount=0;

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        GameInfo.level = level;
    }

    private static int level;

    public static int getPlayTime() {
        return playTime;
    }

    public static void setPlayTime(int playTime) {
        GameInfo.playTime = playTime;
    }

    public static int getStage() {
        return stage;
    }

    public static void setStage(int stage) {
        GameInfo.stage = stage;
    }

    public static int getKillCount() {
        return killCount;
    }

    public static void setKillCount(int killCount) {
        GameInfo.killCount = killCount;
    }


}
