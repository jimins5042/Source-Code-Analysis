package org.newdawn.spaceinvaders.stage;

//난이도 조절하는 클래스

public class SettingValue {
    public SettingValue() {

    }

    //등장하는 적의 수 조절
    private int level[] = {1, 2, 1, 2, 1};
    private static float changeFiringInterval = 500;


    //발사속도 간격 감소 비율
    private static float changeInterval = 1L;
    //적이 내려오는 속도 조절
    private static float AlienY = 10;
    //스테이지 단계
    private static int currentLevel = 0;
    private static float slowInvaderSpeed = 1L;

    private static int changeShip = 1;

    public SettingValue(float changeInterval, float AlienY, int currentLevel, float slowInvaderSpeed) {

        this.changeInterval = changeInterval;
        this.AlienY = AlienY;
        this.currentLevel = currentLevel;
        this.slowInvaderSpeed = slowInvaderSpeed;
    }

    public static float getChangeInterval() {
        return changeInterval;
    }

    public static void setChangeInterval(float changeInterval) {
        SettingValue.changeInterval = changeInterval;
    }


    public void setLevel(int[] level) {
        this.level = level;
    }

    public static int getChangeShip() {
        return changeShip;
    }

    public static void setChangeShip(int changeShip) {
        SettingValue.changeShip = changeShip;
    }

    public int[] getLevel() {
        return level;
    }

    //적 하강속도 비율
    public static float getSlowInvaderSpeed() {
        return slowInvaderSpeed;
    }

    public static void setSlowInvaderSpeed(float slowInvaderSpeed) {
        SettingValue.slowInvaderSpeed = slowInvaderSpeed;
    }

    public static float getChangeFiringInterval() {
        return changeFiringInterval;
    }

    public static void setChangeFiringInterval(float changeFiringInterval) {
        SettingValue.changeFiringInterval = changeFiringInterval;
    }

    public static float getAlienY() {
        return AlienY;
    }

    public static void setAlienY(float alienY) {
        AlienY = alienY;
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int currentLevel) {
        SettingValue.currentLevel = currentLevel;
    }

}
