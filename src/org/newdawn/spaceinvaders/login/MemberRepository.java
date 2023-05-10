package org.newdawn.spaceinvaders.login;

import java.util.*;

public class MemberRepository {

    private static Map<Long, Member> list = new HashMap<>();
    private static Map<String, String> memberMap = new HashMap<>();
    private static long sequence = 0L;
    Member member = new Member();

    public Member saveList(Member member) {

        member.setId(++sequence);

        list.put(member.getId(), member);
        return member;
    }

    public void save(String name, String password) {
        memberMap.put(name, password);
        member.setName(name);
        member.setPassword(password);

        saveList(member);
    }

    public String findPassword(String name) {

        if (memberMap.get(name) == null) {

            System.out.println("비밀번호가 틀렸거나 존재하지 않음");
            return null;
        } else {
            System.out.println("비밀번호는 = " + memberMap.get(name));
            return memberMap.get(name);
        }

    }

    public Map<Long, Member> findAll() {
        return list;
    }
}
