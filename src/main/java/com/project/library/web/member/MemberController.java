package com.project.library.web.member;

import com.project.library.domain.member.Member;
import com.project.library.domain.member.MemberMapper;
import com.project.library.web.SessionConst;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

        memberMapper.insert(member);
        return "redirect:/";
    }

    @GetMapping("/info")
    public String memberInfo(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            return "redirect:/login";
        }
        model.addAttribute("member", loginMember);
        return "members/memberInfo";
    }


}
