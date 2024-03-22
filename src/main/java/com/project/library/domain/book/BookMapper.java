package com.project.library.domain.book;

import com.project.library.domain.book.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookMapper {

    @Insert("INSERT INTO book (id, title, author, category)" +
            "VALUES (book_id_SEQ.NEXTVAL, #{title}, #{author}, #{category})")
    int insert(Book book);

    @Select("SELECT * FROM book")
    List<Book> findAll();

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(Long id);

    @Select("SELECT * FROM book WHERE title = #{title}")
    Optional<Book> findByTitle(String title);

    @Update("UPDATE book SET" +
            "title = #{title}," +
            "author = #{author}," +
            "category = #{category}" +
            "WHERE id = #{id}")
    int update(Book book);

    @Delete("DELETE book WHERE id = #{id}")
    int delete(Long id);
}
