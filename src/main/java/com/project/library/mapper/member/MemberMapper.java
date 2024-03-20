package com.project.library.mapper.member;

import com.project.library.domain.member.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO member (id, login_id, password, name, phone, email, birth_date)" +
            "VALUES (member_id_SEQ.NEXTVAL, #{loginId}, #{password}, #{name}, #{phone}, #{email}, #{birthDate})")
    int insert(Member member);

    @Select("SELECT * FROM member")
    List<Member> findAll();

    @Select("SELECT * FROM member WHERE login_Id = #{loginId}")
    Optional<Member> findByLoginId(String loginId);

    @Update("UPDATE member SET " +
            "login_id = #{loginId}, " +
            "password = #{password}, " +
            "name = #{name}, " +
            "phone = #{phone}, " +
            "email = #{email}, " +
            "birth_date = #{birthDate} WHERE id = #{id}")
    int update(Member member);

    @Delete("DELETE FROM member WHERE id = #{id}")
    int delete(Long id);
}