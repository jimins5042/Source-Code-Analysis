package org.newdawn.spaceinvaders.jdbcdb;

import java.sql.*;

public class ConnectDB {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement psmt = null;
    Statement stmt;

    public void setConnection() {
        String url = "jdbc:mysql://localhost:3306/invader";
        String id = "user1";
        String pw = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, id, pw);
            System.out.println("DB정상연결");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB연결실패");

        }
    }

    public void insertResult(int playTime, int finalStage, int killCount) {

        try {
            String sql = "insert into invader(play_time, stage, kill_count) values (?,?,?)";

            int play_time = playTime;
            int stage = finalStage;
            int kill_count = killCount;

            psmt = con.prepareStatement(sql);
            psmt.setInt(1, play_time);
            psmt.setInt(2, stage);
            psmt.setInt(3, kill_count);
            psmt.executeUpdate();

            System.out.println("쿼리성공_insertResult");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("쿼리실패_insertResult");
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

                System.out.println("플레이타임: " + playTime + " 스테이지: " + stage + " 킬카운트: " + killCount);
            }

            System.out.println("쿼리성공_showResult");
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("쿼리실패_showResult");
            throw new RuntimeException(e);
        }
    }

    public String showBestRecord() {
        String killCount = "최고기록이 없습니다.";

        try {

            stmt = con.createStatement();
            String sql = "select * from invader ORDER BY kill_count desc limit 1";
            rs = psmt.executeQuery(sql);
            //psmt = con.prepareStatement(sql);

            int rowNum = 1;
            while (rs.next()) {
                //int id = rs.getInt("id");

                killCount = rs.getString("kill_count");

                System.out.println("킬카운트: " + killCount);
            }

            System.out.println("쿼리성공_showBestRecord");
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("쿼리실패_showBestRecord");
            throw new RuntimeException(e);
        }

        return killCount;
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

                System.out.println("플레이타임: " + playTime + " 스테이지: " + stage + " 킬카운트: " + killCount);
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