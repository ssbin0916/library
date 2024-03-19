package com.project.library.domain.book;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Book {

    private Long id;

    @NotEmpty
    private String title;
    @NotEmpty
    private String author;
    @NotEmpty
    private Category category;

}
