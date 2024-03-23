package com.project.library.web.loan;

import com.project.library.domain.loan.Loan;
import com.project.library.domain.loan.LoanMapper;
import com.project.library.domain.member.Member;
import com.project.library.web.SessionConst;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {

    private final LoanMapper loanMapper;

    @GetMapping("/rent")
    public String rentForm(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            return "redirect:/login";
        }
        model.addAttribute("member", loginMember);
        return "loans/rentForm";
    }

    @PostMapping("/rent")
    public String rentBook(@Valid @ModelAttribute Loan loan, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "loans/rentForm";
        }
        loanMapper.rentBook(loan);
        return "redirect:/books/books";
    }

    @PutMapping("/{id}/return")
    public String returnBook(@PathVariable("id") Long id) {
        loanMapper.returnBook(id);
        return "redirect:/books/books";
    }
}
