package com.project.library.web.loan;

import com.project.library.domain.loan.LoanMapper;
import com.project.library.domain.member.Member;
import com.project.library.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/loans")
@Slf4j
public class LoanController {

    private final LoanMapper loanMapper;
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    @PostMapping("rent/{bookId}")
    public String rentBook(@PathVariable("bookId") Long bookId, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        if (loginMember == null) {
            return "redirect:/login";
        }
        loanMapper.rentBook(bookId, loginMember.getId());
        loanMapper.isRented(bookId);
        return "redirect:/books/books";
    }

    @PostMapping("return/{bookId}")
    public String returnBook(@PathVariable("bookId") Long bookId, @SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember) {
        if (loginMember == null) {
            return "redirect:/login";
        }
        loanMapper.returnBook(bookId, loginMember.getId());
        loanMapper.isReturned(bookId);
        return "redirect:/books/books";
    }

    @GetMapping("/histories")
    public String loanedHistories(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            return "redirect:/login";
        }

        List<LoanBookDTO> loanedBooks = loanMapper.histories(loginMember.getId());
        model.addAttribute("loanedBooks", loanedBooks);
        return "loans/loanedHistories";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        logger.info("Deleting loan with id: {}", id);
        loanMapper.delete(id);
        return "redirect:/loans/histories";
    }
}
