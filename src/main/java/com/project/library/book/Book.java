package com.project.library.book;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Long bId;
    private String bTitle;
    private String bAuthor;
    private String bCategory;

}
