package com.project.library.domain.loan;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Loan {

    private Long id;

    @NotEmpty
    private Long bookId;
    @NotEmpty
    private Long memberId;
    @NotEmpty
    private LocalDateTime rentDate;
    @NotEmpty
    private LocalDateTime returnDate;

}
