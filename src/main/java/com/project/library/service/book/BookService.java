package com.project.library.service.book;

import com.project.library.domain.book.Book;
import com.project.library.mapper.book.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookMapper.findById(id);
    }

    @Transactional(readOnly = true)
    public Book findByTitle(String title) {
        return bookMapper.findByTitle(title);
    }

    @Transactional
    public void save(Book book) {
        bookMapper.insert(book);
    }

    @Transactional
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Transactional
    public void delete(Long id) {
        bookMapper.delete(id);
    }
}
