package com.project.library.loan;

import java.util.Date;

public class LoanService {

    private LoanDao loanDao;

    public LoanService() throws Exception {
        loanDao = new LoanDaoImpl();
    }

    // 책 대여
    public void rentBook(Long id, Long bId, Date rentDate) throws Exception {
        loanDao.rentBook(id, bId, rentDate);
    }

    // 책 반납
    public void returnBook(Long lId, Date returnDate) throws Exception {
        loanDao.returnBook(lId, returnDate);
    }

    // 대여 기록
    public boolean exists(Long lId) throws Exception {
        return loanDao.exists(lId);
    }
}
