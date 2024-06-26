package com.project.library.web.book;

import com.project.library.domain.book.Book;
import com.project.library.domain.book.BookMapper;
import com.project.library.domain.member.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookMapper bookMapper;

//    @GetMapping("/books")
//    public String books(Model model) {
//        List<Book> books = bookMapper.findAll();
//        model.addAttribute("books", books);
//        return "books/books";
//    }

    @GetMapping("/books")
    public String books(Model model, @SessionAttribute(name = "loginMember", required = false) Member loginMember) {
        List<Book> books = bookMapper.findAll();
        model.addAttribute("books", books);

        // 현재 로그인한 회원 정보를 모델에 추가합니다.
        model.addAttribute("member", loginMember);

        return "books/books";
    }

    @GetMapping("/{id}")
    public String Book(@PathVariable("id") Long id, Model model) {
        Book book = bookMapper.findById(id);
        model.addAttribute("book", book);
        return "books/book";
    }

    @GetMapping("/add")
    public String addForm(@ModelAttribute("book") Book book) {
        return "books/addForm";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/addForm";
        }

        Optional<Book> existBook = bookMapper.findByTitle(book.getTitle());
        if (existBook.isPresent()) {
            bindingResult.rejectValue("title", "title", "이미 존재하는 책입니다.");
            return "books/addForm";
        }

        bookMapper.insert(book);
        return "redirect:/books/books";

    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
        bookMapper.delete(id);
        return "redirect:/books/books";
    }
}
