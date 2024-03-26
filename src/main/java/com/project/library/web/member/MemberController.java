package com.project.library.web.member;

import com.project.library.domain.member.Member;
import com.project.library.domain.member.MemberMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberMapper memberMapper;

    @GetMapping("/add")
    public String joinForm(@ModelAttribute("member") Member member) {
        return "members/joinForm";
    }

    @PostMapping("/add")
    public String join(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/joinForm";
        }

        Optional<Member> existLoginId = memberMapper.findByLoginId(member.getLoginId());
        if (existLoginId.isPresent()) {
            bindingResult.rejectValue("loginId", "duplicate", "이미 사용 중인 아이디입니다.");
            return "members/joinForm";
        }

        if (!member.getPassword().equals(member.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "password.mismatch", "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return "members/joinForm";
        }

        memberMapper.insert(member);
        return "redirect:/";
    }

}
