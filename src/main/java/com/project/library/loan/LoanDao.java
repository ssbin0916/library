package com.project.library.loan;

import java.util.Date;

public interface LoanDao {

    void rentBook(Long id, Long bId, Date rentDate) throws Exception; // 책 대여

    void returnBook(Long lId, Date returnDate) throws Exception; // 책 반납

    boolean exists(Long lId) throws Exception; // 대여 기록
}
