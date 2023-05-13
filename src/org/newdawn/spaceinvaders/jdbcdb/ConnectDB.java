package org.newdawn.spaceinvaders.jdbcdb;

import org.newdawn.spaceinvaders.login.Member;
import org.newdawn.spaceinvaders.stage.StageLevel;
import org.newdawn.spaceinvaders.stage.shop.Coin;

import java.sql.*;

public class ConnectDB {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement psmt = null;
    Statement stmt;

    Coin c = new Coin();
    Member member = new Member();
    StageLevel level = new StageLevel();

    GameInfo info = new GameInfo();

    public void setConnection() {
        String url = "jdbc:mysql://localhost:3306/invader";
        String id = "user1";
        String pw = "";

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, pw);
            System.out.println("DB정상연결");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB연결실패");

        }
    }

    public void insertResult() {

        try {
            String sql = "insert into invader(play_time, stage, kill_count, play_score, coin, name, password) values (?,?,?, ?,?, ?, ?)";

            int play_time = info.getPlayTime();
            int stage = level.getCurrentLevel();
            int kill_count = info.getKillCount();
            int play_score = info.getScore();
            int coin = c.getCoin();
            String name = member.getLoginName();
            String password = member.getLoginPassword();

            psmt = con.prepareStatement(sql);
            psmt.setInt(1, play_time);
            psmt.setInt(2, stage);
            psmt.setInt(3, kill_count);
            psmt.setInt(4, play_score);
            psmt.setInt(5, coin);
            psmt.setString(6, name);
            psmt.setString(7, password);
            psmt.executeUpdate();

            System.out.println("쿼리성공_insertResult");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("쿼리실패_insertResult");
        }
    }

    public void updateResult() {

        try {

            String sql = "update invader set play_time = ?, stage = ?, kill_count = ?, play_score = ? ,coin =? where name =? and password = ? ORDER BY ID DESC LIMIT 1";

            int play_time = info.getPlayTime();
            int stage = level.getCurrentLevel();
            int kill_count = info.getKillCount();
            int play_score = info.getScore();
            int coin = c.getCoin();
            String name = member.getLoginName();
            String password = member.getLoginPassword();

            psmt = con.prepareStatement(sql);
            psmt.setInt(1, play_time);
            psmt.setInt(2, stage);
            psmt.setInt(3, kill_count);
            psmt.setInt(4, play_score);
            psmt.setInt(5, coin);
            psmt.setString(6, name);
            psmt.setString(7, password);
            psmt.executeUpdate();

            System.out.println("쿼리성공_updateResult");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("쿼리실패_updateResult");
        }
    }

    public void showResult() {
        try {

            stmt = con.createStatement();
            String sql = "select * from invader";
            rs = psmt.executeQuery(sql);
            //psmt = con.prepareStatement(sql);

            int rowNum = 1;
            while (rs.next()) {
                int playTime = rs.getInt("play_time");
                String stage = rs.getString("stage");
                String killCount = rs.getString("kill_count");
                int score = rs.getInt("play_score");

                System.out.println("플레이타임: " + playTime + " 스테이지: " + stage + " 킬카운트: " + killCount + " 점수 " + score);
            }

            System.out.println("쿼리성공_showResult");
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("쿼리실패_showResult");
            throw new RuntimeException(e);
        }
    }

    public int showBestRecord() {
        String killCount = "최고기록이 없습니다.";
        int best = 0;

        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM invader WHERE name = '" + member.getLoginName() + "' ORDER BY play_score DESC LIMIT 1";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                killCount = rs.getString("kill_count");
                best = rs.getInt("play_score");

                System.out.println("킬카운트: " + killCount);
                System.out.println("최고점수: " + best);

            }

            System.out.println("쿼리성공_showBestRecord");
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("쿼리실패_showBestRecord");
            throw new RuntimeException(e);
        }
        System.out.println("score" +  best);
        return best;

    }

    public void currentRecord() {

        try {

            stmt = con.createStatement();
            String sql = "select * from invader ORDER BY id desc limit 1";
            rs = psmt.executeQuery(sql);
            //psmt = con.prepareStatement(sql);

            int rowNum = 1;
            while (rs.next()) {
                int playTime = rs.getInt("play_time");
                String stage = rs.getString("stage");
                String killCount = rs.getString("kill_count");
                int score = rs.getInt("play_score");

                System.out.println("플레이타임: " + playTime + " 스테이지: " + stage + " 킬카운트: " + killCount + " 점수 " + score);


            }

            System.out.println("쿼리성공_currentRecord");
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("쿼리실패_currentRecord");
            throw new RuntimeException(e);
        }

    }
}