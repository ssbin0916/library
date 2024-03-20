package com.project.library.domain.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper bookMapper;

    @Transactional(readOnly = true)
    public List<Book> findAll() throws Exception {
        return bookMapper.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) throws Exception {
        return bookMapper.findById(id);
    }

    @Transactional(readOnly = true)
    public Book findByTitle(String title) throws Exception {
        return bookMapper.findByTitle(title);
    }

    @Transactional
    public void save(Book book) throws Exception {
        bookMapper.insert(book);
    }

    @Transactional
    public void update(Book book) throws Exception {
        bookMapper.update(book);
    }

    @Transactional
    public void delete(Long id) throws Exception {
        bookMapper.delete(id);
    }
}
