package org.newdawn.spaceinvaders.stage;

import org.newdawn.spaceinvaders.entity.AlienEntity;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;

import java.util.ArrayList;
import java.util.HashMap;

//난이도 조절하는 클래스

public class StageLevel {
    public StageLevel() {

    }

    //등장하는 적의 수 조절
    private int level[] = {1, 2, 1, 2, 1};
    private static float changeFiringInterval = 500;
    //적이 내려오는 속도 조절
    private static float AlienY = 10;
    //스테이지 단계
    private static int currentLevel = 0;
    private static float slowInvaderSpeed = 1L;

    public StageLevel(float changeFiringInterval, float AlienY, int currentLevel, float slowInvaderSpeed) {

        this.changeFiringInterval = changeFiringInterval;
        this.AlienY = AlienY;
        this.currentLevel = currentLevel;
        this.slowInvaderSpeed = slowInvaderSpeed;
    }



    public int[] getLevel() {
        return level;
    }

    //적 하강속도 비율
    public static float getSlowInvaderSpeed() {
        return slowInvaderSpeed;
    }

    public static void setSlowInvaderSpeed(float slowInvaderSpeed) {
        StageLevel.slowInvaderSpeed = slowInvaderSpeed;
    }

    public static float getChangeFiringInterval() {
        return changeFiringInterval;
    }

    public static void setChangeFiringInterval(float changeFiringInterval) {
        StageLevel.changeFiringInterval = changeFiringInterval;
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
        StageLevel.currentLevel = currentLevel;
    }

}
