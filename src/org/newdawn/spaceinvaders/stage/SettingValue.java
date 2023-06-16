package org.newdawn.spaceinvaders.stage;

//난이도 조절하는 클래스

public class SettingValue {
    public SettingValue() {

    }

    //등장하는 적의 수 조절
<<<<<<< HEAD
=======
    private int level[] = {1, 2, 1, 2, 1};
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
    private static float changeFiringInterval = 500;


    //발사속도 간격 감소 비율
    private static float changeInterval = 1L;
    //적이 내려오는 속도 조절
    private static float AlienY = 10;
    //스테이지 단계

    private static float slowInvaderSpeed = 1L;

    private static int changeShip = 1;
<<<<<<< HEAD
    private static int changeShip2 = 1;
=======
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952

    public SettingValue(float changeInterval, float AlienY, float slowInvaderSpeed) {

        this.changeInterval = changeInterval;
        this.AlienY = AlienY;

        this.slowInvaderSpeed = slowInvaderSpeed;
    }

    public static float getChangeInterval() {
        return changeInterval;
    }

    public static void setChangeInterval(float changeInterval) {
        SettingValue.changeInterval = changeInterval;
    }


<<<<<<< HEAD
=======
    public void setLevel(int[] level) {
        this.level = level;
    }
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952

    public static int getChangeShip() {
        return changeShip;
    }

    public static void setChangeShip(int changeShip) {
        SettingValue.changeShip = changeShip;
    }

<<<<<<< HEAD
=======
    public int[] getLevel() {
        return level;
    }

>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
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

<<<<<<< HEAD
    public static int getChangeShip2() {
        return changeShip2;
    }

    public static void setChangeShip2(int changeShip2) {
        SettingValue.changeShip2 = changeShip2;
    }

=======
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
    public static float getAlienY() {
        return AlienY;
    }

    public static void setAlienY(float alienY) {
        AlienY = alienY;
    }


}
