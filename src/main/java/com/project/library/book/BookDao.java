package com.project.library.book;

public interface BookDao {

    int insert(Book book) throws Exception; // 책 입력

    int update(Book book) throws Exception; // 책 수정

    int delete(Long bId) throws Exception; // 책 삭제

}
