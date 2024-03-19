package com.project.library.loan;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    private Long lId;
    private Long id;
    private Long bId;
    private Date rentDate;
    private Date returnDate;
}
