package org.newdawn.spaceinvaders.stage.shop;

import org.newdawn.spaceinvaders.stage.StageLevel;

public class ShopService {

    float increaseShotSpeed;
    //적 하강속도

    //발사속도 관련
    private int i = 10;

    public float getIncreaseShotSpeed() {
        return increaseShotSpeed;
    }

    public void setIncreaseShotSpeed(float increaseShotSpeed) {
        this.increaseShotSpeed = increaseShotSpeed;
    }



    /*
    -발사속도 증가 능력치 증가 로직-
        기본 발사속도(500) * 발사속도 증가값
        -> 발사간격을 줄이는 로직
    */
    public void Increase() {
        StageLevel level = new StageLevel();
        Coin coin = new Coin();
        coin.setCoin(100);

        System.out.println("상점 메소드 하기 전 = " + level.getChangeFiringInterval());
        //price = 능력치 구매 가격
        level.setChangeFiringInterval(500);
        boolean pur = purchase(5);

        //purchase 함수에서 받은 리턴 값으로 아래 능력치 증.감 로직을 실행시킬지 안시킬지를 정함
        if (pur) {
            if (i <= 1) {
                System.out.println("발사속도 최대 증가");
            } else {
                i--;
                level.setChangeFiringInterval((level.getChangeFiringInterval() * i) / 10);

                System.out.println("발사 속도 증가 성공 : 현재 속도: " + level.getChangeFiringInterval());
            }
        }
    }


    /*
    -적 하강속도 감소 로직-
        적 하강속도의 경우 다음의 공식을 따른다
        (10 + 5 * 현재 스테이지 단계) * 하강 속도 감소 비율
    */
    public void Decrease() {
        StageLevel level = new StageLevel();
        // price = 능력치 구매 가격
        boolean pur = purchase(10);

        //purchase 함수에서 받은 리턴 값으로 아래 능력치 증.감 로직을 실행시킬지 안시킬지를 정함
        if (pur) {
            if (level.getSlowInvaderSpeed() <= 0.1) {
                System.out.println("적 하강속도 최대 감소");
            } else {
                level.setSlowInvaderSpeed((float) (level.getSlowInvaderSpeed() - 0.1));

                System.out.println("적 하강속도 감소 성공 : 현재 감소비율: " + level.getSlowInvaderSpeed());
            }
        }
    }

    //상점 능력치 구매로직
    public boolean purchase(int price) {
        Coin coin = new Coin();

        //잔액이 부족하면 false를 리턴
        if ((coin.getCoin() - price) < 0) {
            System.out.println("잔액부족 - 현재 코인 : " + coin.getCoin());
            return false;
        }
        //잔액이 충분하면 true를 리턴
        else {
            coin.setCoin(coin.getCoin() - price);
            System.out.println("구매성공 - 남은 코인 : " + coin.getCoin());
            return true;
        }
    }


}
