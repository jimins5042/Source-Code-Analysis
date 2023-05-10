package org.newdawn.spaceinvaders.stage.shop;

public class Coin {
    //테스트용으로 50원 넣어놨음
    //private int coin = 50;
    private static int coin = 50;

    public static int getCoin() {
        return coin;
    }
    public static void setCoin(int coin) {
        Coin.coin = coin;
    }
}
