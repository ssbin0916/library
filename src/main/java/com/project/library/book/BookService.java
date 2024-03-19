package com.project.library.book;

public class BookService {

    private BookDao bookDao;

    public BookService() throws Exception {
        bookDao = new BookDaoImpl();
    }

    // 책 등록
    public int insert(Book book) throws Exception {
        return bookDao.insert(book);
    }

    // 책 수정
    public int update(Book book) throws Exception {
        return bookDao.update(book);
    }

    // 책 삭제
    public int delete(Long bId) throws Exception {
        return bookDao.delete(bId);
    }

}
