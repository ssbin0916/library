package com.project.library.web.loan;

import lombok.Data;

@Data
public class LoanBookDTO {

    private Long id;
    private Long bookId;
    private Long memberId;
    private String title;
    private String author;
    private String category;
    private String rentDate;
    private String returnDate;
}
