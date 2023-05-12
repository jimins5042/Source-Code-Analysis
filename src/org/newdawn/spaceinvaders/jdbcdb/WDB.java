package org.newdawn.spaceinvaders.jdbcdb;

import java.sql.*;

public class WDB {

    public static void main(String[] args) throws Exception {
        //드라이버 로드

        ConnectDB db = new ConnectDB();

        db.setConnection();
        db.insertResult();
        db.showResult();
        db.showBestRecord();
        db.currentRecord();
    }
}