package com.project.library.domain.login;

import com.project.library.domain.member.Member;
import com.project.library.domain.member.MemberMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class LoginServiceTest {

    @Test
    void loginSuccess() {
        String loginId = "testId";
        String password = "testPass";

        Member member = new Member();
        member.setLoginId(loginId);
        member.setPassword(password);

        MemberMapper memberMapper = Mockito.mock(MemberMapper.class);

        when(memberMapper.findByLoginId(anyString())).thenReturn(Optional.of(member));

        LoginService loginService = new LoginService(memberMapper);

        Member loginMember = loginService.login(loginId, password);

        assertEquals(loginId, loginMember.getLoginId());
    }

    @Test
    void wrongPassword() {
        String loginId = "testId";
        String correctPass = "correctPass";
        String wrongPass = "wrongPass";

        Member member = new Member();
        member.setLoginId(loginId);
        member.setPassword(correctPass);

        MemberMapper memberMapper = Mockito.mock(MemberMapper.class);

        when(memberMapper.findByLoginId(anyString())).thenReturn(Optional.of(member));

        LoginService loginService = new LoginService(memberMapper);

        Member loggedInMember = loginService.login(loginId, wrongPass);

        assertEquals(null, loggedInMember);
    }

    @Test
    void memberNotFound() {
        String noneId = "noneId";
        String password = "password";

        MemberMapper memberMapper = Mockito.mock(MemberMapper.class);

        when(memberMapper.findByLoginId(anyString())).thenReturn(Optional.empty());

        LoginService loginService = new LoginService(memberMapper);

        Member loggedInMember = loginService.login(noneId, password);

        assertEquals(null, loggedInMember);
    }
}