package com.project.library.service.loan;

import com.project.library.domain.loan.Loan;
import com.project.library.mapper.loan.LoanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanMapper loanMapper;

    @Transactional
    public void rentBook(Loan loan) {
        loanMapper.rentBook(loan);
    }

    @Transactional
    public void returnBook(Long id) {
        loanMapper.returnBook(id);
    }

    @Transactional
    public void exist(Long id) {
        loanMapper.exist(id);
    }
}
