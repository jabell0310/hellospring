package com.example.hellospring.repository;

import com.example.hellospring.model.Board;
import com.example.hellospring.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MemberRepository {

    static public ArrayList<Member> members;

    static {
        members = new ArrayList<>();
        members.add(new Member(1,"Fromsoftware","fromsoftware@gmail.com","japan"));
        members.add(new Member(2,"Supergiantgame","supergiantgame@gmail.com","usa"));
        members.add(new Member(3,"Hazelight","hazelight@gmail.com","belgium"));
        members.add(new Member(1,"Fromsoftware","fromsoftware@gmail.com","japan"));
        members.add(new Member(4,"Larian","larian@gmail.com","belgium"));
    }

    public Member create(Member member) {
        members.add(member);
        return member;
    }

    public ArrayList<Member> findAll() {
        return members;
    }

    public Member findById(String id) {
        return members.stream()
                .filter(Member -> Member.getId().equals(Integer.parseInt(id)))
                .findAny()
                .orElse(new Member(null,"","",""));
    }

    public void updateName(String id, Member member) {
        members.stream()
                .filter(Community -> Community.getId().equals(Integer.parseInt(id)))
                .findAny()
                .orElse(new Member(null,"","",""))
                .setName(member.getName());

    }

    public void delete(String id) {
        members.removeIf(Member -> Member.getId().equals(Integer.parseInt(id)));
    }
}
