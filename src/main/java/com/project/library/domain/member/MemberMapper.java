package com.project.library.domain.member;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO member (id, login_id, password, name)" +
            "VALUES (member_id_SEQ.NEXTVAL, #{loginId}, #{password}, #{name})")
    void insert(Member member);

    @Select("SELECT * FROM member")
    List<Member> findAll();

    @Select("SELECT * FROM member WHERE id = #{id}")
    Member findById(Long id);

    @Select("SELECT * FROM member WHERE login_id = #{loginId}")
    Optional<Member> findByLoginId(String loginId);

    @Update("UPDATE member SET " +
            "login_id = #{loginId}, " +
            "password = #{password}," +
            "name = #{name} " +
            "WHERE id = #{id}")
    int update(Member member);

    @Delete("DELETE FROM member WHERE id = #{id}")
    int delete(Long id);
}
