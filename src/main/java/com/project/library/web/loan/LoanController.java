package com.project.library.web.loan;

import com.project.library.domain.loan.Loan;
import com.project.library.domain.loan.LoanMapper;
import com.project.library.domain.member.Member;
import com.project.library.web.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoanController {

    private final LoanMapper loanMapper;

    @GetMapping("/histories")
    public String loanedHistories(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            return "redirect:/login";
        }

        List<Loan> loanedBooks = loanMapper.findLoanedBooksByMemberId(loginMember.getId());
        model.addAttribute("loanedBooks", loanedBooks);
        return "loans/loanedHistories";
    }
}
