package com.project.library.domain.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Book {

    private Long id;

    @NotBlank(message = "제목 입력은 필수입니다.")
    private String title;
    @NotBlank(message = "저자 입력은 필수입니다.")
    private String author;
    @NotNull(message = "장르 입력은 필수입니다.")
    private Category category;

    private String isRented;
}
