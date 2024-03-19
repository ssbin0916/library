package com.project.library.domain.book;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookMapper {

    @Insert("INSERT INTO book (id, title, author, category)" +
            "VALUES (book_id_SEQ.NEXTVAL, #{title}, #{author}, #{category})")
    int insert(Book book) throws Exception;

    @Select("SELECT * FROM book")
    List<Book> findAll() throws Exception;

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(Long id) throws Exception;

    @Select("SELECT * FROM book WHERE title = #{title}")
    Book findByTitle(String title) throws Exception;

    @Update("UPDATE member SET" +
            "title = #{title}" +
            "author = #{author}" +
            "category = #{category}" +
            "WHERE id = #{id}")
    int update(Book book) throws Exception;

    @Delete("DELETE book WHERE id = #{id}")
    int delete(Long id) throws Exception;
}
