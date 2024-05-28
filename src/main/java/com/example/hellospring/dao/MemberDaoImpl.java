package com.example.hellospring.dao;


import com.example.hellospring.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    private static final String INSERT_MEMBER_QUERY = "INSERT INTO MEMBER(id,name,email,password) values (?,?,?,?)";
    private static final String GET_MEMBERS_QUERY = "SELECT * FROM MEMBER";
    private static final String GET_MEMBER_BY_ID_QUERY = "SELECT * FROM MEMBER WHERE ID=?";

    private static final String GET_MEMBER_BY_NAME_QUERY = "SELECT id FROM MEMBER WHERE NAME=?";
    private static final String UPDATE_MEMBERS_BY_ID_QUERY = "UPDATE MEMBER SET name=? WHERE ID=?";
    private static final String DELETE_MEMBER_BY_ID = "DELETE FROM MEMBER WHERE ID=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createMember(Member member) {
        jdbcTemplate.update(INSERT_MEMBER_QUERY,member.getId(),member.getName(),member.getEmail(),member.getPassword());
    }

    @Override
    public List<Member> findMembers() {
        return jdbcTemplate.query(GET_MEMBERS_QUERY,(rs, rowNum) -> {
            return new Member(rs.getInt("id"),rs.getString("name"), rs.getString("email"), rs.getString("password"));
        });
    }

    @Override
    public Member getById(int id) {
        return jdbcTemplate.queryForObject(GET_MEMBER_BY_ID_QUERY, (rs, rowNum) -> {
            return new Member(rs.getInt("id"),rs.getString("name"), rs.getString("email"), rs.getString("password"));
        }, id);
    }

    public Member getIdByName(String name) {
        return jdbcTemplate.queryForObject(GET_MEMBER_BY_NAME_QUERY, (rs, rowNum) -> {
            return new Member(rs.getInt("id"),rs.getString("name"), rs.getString("email"), rs.getString("password"));
        }, name);
    }

    @Override
    public Member updateName(Member member) {
        jdbcTemplate.update(UPDATE_MEMBERS_BY_ID_QUERY,member.getName(),member.getId());
        return member;
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(DELETE_MEMBER_BY_ID,id);
    }
}
