package com.project.library.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.Date;

public interface LoanMapper {

    @Insert("INSERT INTO LOAN (LID, ID, BID, RENT_DATE) VALUES (LOAN_SEQ.NEXTVAL, #{id}, #{bId}, #{rentDate})")
    void rentBook(@Param("id") Long id, @Param("bId") Long bId, @Param("rentDate") Date rentDate) throws Exception; // 책 대여

    @Update("UPDATE LOAN SET RETURN_DATE = #{returnDate} WHERE LID = #{lId}")
    void returnBook(@Param("lId") Long lId, @Param("returnDate") Date returnDate) throws Exception; // 책 반납

    @Select("SELECT COUNT(*) FROM LOAN WHERE LID = #{lId}")
    int exists(@Param("lId") Long lId) throws Exception; // 대여 기록
}
