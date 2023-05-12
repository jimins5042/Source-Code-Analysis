package org.newdawn.spaceinvaders.login;

public class Member {

    private static long id;
    private static String name;
    private static String password;
    //로그인 여부를 판단하는 변수
    private static boolean loginCookie = false;

    //새 게임이 시작되는지 판단하는 변수
    private static boolean gameCookie = false;

    public static boolean isGameCookie() {
        return gameCookie;
    }

    public static void setGameCookie(boolean gameCookie) {
        Member.gameCookie = gameCookie;
    }

    private static String loginName;
    private static String loginPassword;


    public static boolean isLoginCookie() {
        return loginCookie;
    }



    public static void setLoginCookie(boolean logonCookie) {
        Member.loginCookie = logonCookie;
    }

    public static String getLoginName() {
        return loginName;
    }

    public static void setLoginName(String loginName) {
        Member.loginName = loginName;
    }

    public static String getLoginPassword() {
        return loginPassword;
    }

    public static void setLoginPassword(String loginPassword) {
        Member.loginPassword = loginPassword;
    }

    public static long getId() {
        return id;
    }
    public static void setId(long id) {
        Member.id = id;
    }
    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        Member.name = name;
    }
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        Member.password = password;
    }

    public Member() {
    }

    public Member(long id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
