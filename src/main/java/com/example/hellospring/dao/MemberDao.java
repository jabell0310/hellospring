package com.example.hellospring.dao;

import com.example.hellospring.model.Member;

import java.util.List;

public interface MemberDao {
    public void createMember(Member member);

    public List<Member> findMembers();

    public Member getById(int id);

    public Member getIdByName(String name);

    public Member updateName(Member member);

    public void deleteById(int id);
}
