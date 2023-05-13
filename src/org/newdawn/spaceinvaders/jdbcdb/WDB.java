package org.newdawn.spaceinvaders.jdbcdb;

import org.newdawn.spaceinvaders.login.Member;
import org.newdawn.spaceinvaders.stage.StageLevel;
import org.newdawn.spaceinvaders.stage.shop.Coin;

import java.sql.*;

public class WDB {

    public static void main(String[] args) throws Exception {
        //드라이버 로드

        StageLevel level = new StageLevel();
        GameInfo info = new GameInfo();
        Coin coin = new Coin();
        Member member = new Member();

        info.setPlayTime(20);
        level.setCurrentLevel(2);
        info.setKillCount(50);
        coin.setCoin(50);
        info.setScore(500);
        member.setName("testId");
        member.setPassword("testPw");
        System.out.printf("insert 쿼리 -> 시간: %d 스테이지 : %d 킬카운트 : %d 코인 : %d 이름 : %s 비밀번호 : %s",
                info.getPlayTime(), level.getCurrentLevel(),
                info.getKillCount(), coin.getCoin(),
                member.getName(), member.getPassword());

        ConnectDB db = new ConnectDB();
        db.setConnection();
        db.insertResult();

        info.setPlayTime(40);
        level.setCurrentLevel(4);
        info.setKillCount(20);
        coin.setCoin(30);
        info.setScore(1100);

        System.out.printf("update 쿼리 -> 시간: %d 스테이지 : %d 킬카운트 : %d 코인 : %d 이름 : %s 비밀번호 : %s ",
                info.getPlayTime(), level.getCurrentLevel(),
                info.getKillCount(), coin.getCoin(),
                member.getName(), member.getPassword());

        db.updateResult();
        db.showResult();
        int n = db.showBestRecord();
        System.out.println("n = " + n);
        db.currentRecord();
    }
}