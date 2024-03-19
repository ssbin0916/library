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

    
}
