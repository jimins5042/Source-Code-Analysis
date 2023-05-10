package org.newdawn.spaceinvaders.login;

public class Member {

    private static long id;
    private static String name;
    private static String password;

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
