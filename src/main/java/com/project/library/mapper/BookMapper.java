package com.project.library.mapper;

import com.project.library.book.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface BookMapper {

    @Insert("INSERT INTO BOOK (BID, BTITLE, BAUTHOR, BCATEGORY)\n" +
            "\tVALUES(BOOK_SEQ.NEXTVAL, #{bTitle}, #{bAuthor}, #{bCategory})")
    int insert(Book book) throws Exception; // 책 입력

    @Update("UPDATE BOOK \n" +
            "SET\tBTITLE = #{bTitle},\n" +
            "\tBAUTHOR = #{bAuthor},\n" +
            "\tBCATEGORY = #{bCategory}\n" +
            "WHERE BID = #{bId}")
    int update(Book book) throws Exception; // 책 수정

    @Delete("DELETE BOOK WHERE BID = #{bId}")
    int delete(Long bIn) throws Exception; // 책 삭제

}
