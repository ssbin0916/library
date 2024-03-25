package com.project.library.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private Long id;

    @NotEmpty(message = "아이디를 입력하세요")
    private String loginId;
    @NotEmpty(message = "비밀번호를 입력하세요")
    private String password;
    @NotEmpty(message = "이름을 입력하세요")
    private String name;

    @NotEmpty(message = "비밀번호 확인을 입력하세요")
    private String confirmPassword;
}
