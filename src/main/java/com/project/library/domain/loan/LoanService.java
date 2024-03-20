package com.project.library.domain.loan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanMapper loanMapper;

    @Transactional
    public void rentBook(Loan loan) throws Exception {
        loanMapper.rentBook(loan);
    }

    @Transactional
    public void returnBook(Long id) throws Exception {
        loanMapper.returnBook(id);
    }

    @Transactional
    public void exist(Long id) throws Exception {
        loanMapper.exists(id);
    }
}
